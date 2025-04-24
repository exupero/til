# Use `update-vals` to map a hash-map's values

Whenever I've needed to map the values of a hash-map through a function, I usually resort to this pattern:

```clojure
(into {}
      (map (fn [[k v]]
             [k (f v)]))
      m)
```

I could have written a helper function for it, but it's become muscle memory at this point.

Today I learned that Clojure 1.11 added the [`update-vals`](https://github.com/clojure/clojure/blob/8ae9e4f95e2fbbd4ee4ee3c627088c45ab44fa68/src/clj/clojure/core.clj#L8132) function, which does the same thing.
It uses a transient (which `into` also uses) and adds the metadata of the original hash-map to its return value.

1.11 also added `update-keys`, but that I don't typically need as often.
