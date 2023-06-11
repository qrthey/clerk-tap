(ns qrthey.clerk-tap.core
  (:require [nextjournal.clerk :as clerk]
            [qrthey.clerk-tap.notebook]
            [qrthey.clerk-tap.state :as state]))

(defn start-clerk-tap
  [& {:keys [port] :or {port 7777}}]
  (if (state/connected-to-tap?)
    (throw (Exception. "Clerk-Tap is already running."))
    (do
      (clerk/serve! {:port port :browse? true})
      (Thread/sleep 500)
      (state/connect-to-tap))))

(defn stop-clerk-tap
  []
  (when (state/connected-to-tap?)
    (state/disconnect-from-tap)
    (clerk/halt!)))

(defn keep-last
  [n]
  (state/keep-last-n n))
