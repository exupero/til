# Meander patterns match remaining key-values with &

I wanted to use [Meander](https://github.com/noprompt/meander) to rewrite a specific key in a hash-map.
I knew how to use `meander.strategy.epsilon/match` to capture the whole hash-map and `assoc` a new value into it, but to learn how to check for a particular key and use `meander.strategy.epsilon/rewrite` to rewrite it, I had to dig through the [docs](https://github.com/noprompt/meander/tree/epsilon/doc) until I found that the [`&` operator matches the rest of maps](https://github.com/noprompt/meander/blob/epsilon/doc/operator-overview.md#rest):

```clojure
(require '[meander.strategy.epsilon :as m*])

(def f
  (m*/rewrite
    {:text ?text & ?props}
    , {:text "something else" & ?props}))

(f {:a 1 :b 2 :text 3 :c 4}) ;=> {:a 1, :b 2, :c 4, :text "something else"}
```
