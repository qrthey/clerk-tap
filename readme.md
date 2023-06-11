# Clerk-Tap

Clerk-Tap uses the amazing [Clerk notebook library from
Nextjournal](https://github.com/nextjournal/clerk) to visualize
`clojure.core/tap>`-ed values, in most-recent-first order.

## Installation

Clerk-Tap is available on clojars.

[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.qrthey/clerk-tap.svg)](https://clojars.org/org.clojars.qrthey/clerk-tap)

## Usage

Clerk-Tap would typically not be included in produced artifacts, but
only included in a dev profile/alias.

The following code requires the `qrthey.clerk-tap.core` namespace, and
lists the most important functions in a comment block, ready to be
evaluated when connected to a repl.

``` clojure
    (ns user
      (:require [qrthey.clerk-tap.core :as clerk-tap]))

    (comment

      (clerk-tap/start-clerk-tap :port 7788)
      (clerk-tap/stop-clerk-tap)
      (clerk-tap/keep-last 10)

    )
```

- `start-clerk-tap` optionally takes a `:port` keyword argument. If
  this is ommitted, port 7777 is used by default. Invoking this
  function opens a browser window with the Clerk-Tap interface running
  on localhost. Once Clerk-Tap is running, use `clojure.core/tap>` to
  visualize value(s) of interest.
- `stop-clerk-tap` stops the server and makes Clerk-Tap forget the
  values it has already observed.
- `keep-last` takes a numeric argument and discards all but the last
  /n/ observed values.
