# Clojure.edn/read-string accepts a :default opt for unknown reader tags

Clojure's built-in [`clojure.edn/read-string`](https://clojure.github.io/clojure/clojure.edn-api.html#clojure.edn/read-string) function parses [EDN](https://github.com/edn-format/edn) into Clojure data, including tagged literals.
I've only used that ability in cases where all tags were known beforehand and tag handlers could be specified via the `:readers` option, but today I wanted to parse a file without knowing what readers it might have.
Turns out `read-string` also accepts a `:default` option, which is called with any unknown tag and the literal it tags.

A convenient function to use for `:default` is [`clojure.core/tagged-literal`](https://clojure.github.io/clojure/clojure.core-api.html#clojure.core/tagged-literal) whose tag and data literal can be accessed with `:tag` and `:form`, respectively.
