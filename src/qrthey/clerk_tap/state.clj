(ns qrthey.clerk-tap.state
  (:require [nextjournal.clerk :as clerk]))

(defonce tapped-values (atom nil))

(defn connected-to-tap?
  []
  (boolean @tapped-values))

(defn- render-state
  []
  (clerk/show! (find-ns 'qrthey.clerk-tap.notebook)))

(defn- tap-fn
  [v]
  (swap! tapped-values conj v)
  (render-state))

(defn connect-to-tap
  []
  (reset! tapped-values [])
  (add-tap tap-fn)
  (render-state))

(defn disconnect-from-tap
  []
  (remove-tap tap-fn)
  (reset! tapped-values nil))

(defn keep-last-n
  [n]
  (swap! tapped-values #(vec (take-last n %)))
  (render-state))
