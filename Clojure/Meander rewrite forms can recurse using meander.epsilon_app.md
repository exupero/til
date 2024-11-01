# Meander rewrite forms can recurse using meander.epsilon/app

Tinkering with a [small module](https://github.com/exupero/bblib/blob/main/python.clj) to turn Clojure forms into Python ASTs, I had written some branchy tree-walking code that wasn't holding up, so I took a look at how [Kalai](https://github.com/kalai-transpiler/kalai) turns Clojure into Rust, C++, and Java.
Its strategy is to make several small transformation passes using [Meander](https://github.com/noprompt/meander) to pattern match and rewrite terms.

I've played with Meander before, but not used explicit recursion, instead relying on `meander.strategy.epsilon/bottom-up` to rewrite terms at different places in a nested structure.
Kalai's source code illustrated how to control recursion more precisely, namely by using `meander.epsilon/app`.
Here's a small example:

```clojure
(require '[meander.epsilon :as m]
         '[meander.strategy.epsilon :as m*])

(def expand
  (m*/rewrite
    [?a]
    , [?a ?a]
    [?a ?b]
    , [(m/app expand [?a]) (m/app expand [?b])]
    ?else
    , ?else))

(expand [1 2]) ; [[1 1] [2 2]]]
```

Note that pattern substitutions are able to refer to the name the strategy is bound to.
