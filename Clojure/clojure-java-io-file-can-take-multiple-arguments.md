# clojure.java.io/file can take multiple arguments

I've always used [`clojure.java.io/file`](https://clojure.github.io/clojure/clojure.java.io-api.html#clojure.java.io/file) with a single argument, but it can actually take multiple arguments, which it uses to construct a file nested within ancestor directories.
For example,

```clojure
(clojure.java.io/file "parent" "child" "grandchild")
```

will construct a relative `File` object that's to the current directory at `parent/child/grandchild`.
