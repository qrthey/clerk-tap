(ns qrthey.clerk-tap.notebook
  {:nextjournal.clerk/visibility {:code :hide :result :hide}}
  (:require [nextjournal.clerk :as clerk]
            [qrthey.clerk-tap.state :as state]))

;; # Clerk-Tap

{:nextjournal.clerk/visibility {:result :show}}
(if (seq @state/tapped-values)
  (reverse @state/tapped-values)
  (clerk/md
   (str "## *no tapped values observed yet*\n\n"
        "Use `clojure.core/tap>` to visualize value(s) of interest.")))


;; ## Usage

;; Once Clerk-Tap is running, use `clojure.core/tap>` to visualize
;; value(s) of interest.

;; The following functions are all defined in the
;; `qrthey.clerk-tap.core` namespace.

;; - Start Clerk-Tap with `start-clerk-tap`. After invoking this
;; function, a server is started and any value that is 'tapped' is
;; observed and rendered by Clerk-Tap in a browser window. You already
;; successfully invoked this function.

;; - Stop Clerk-Tap with `stop-clerk-tap`. This stops the server and
;; makes Clerk-Tap forget the values it has already observed.

;; - To discard all but last *n* observed values, use `keep-last`.

;; ## About

;; [Clerk-Tap](https://github.com/qrthey/clerk-tap) uses the
;; amazing [Clerk notebook library from
;; Nextjournal](https://github.com/nextjournal/clerk) to visualize
;; `clojure.core/tap>`-ed values, in most-recent-first order.
