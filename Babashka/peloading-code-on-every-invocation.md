# Peloading code on every invocation

Before each invocation [Babashka](https://github.com/babashka/babashka) runs the content of the [`BABASHKA_PRELOADS`](https://book.babashka.org/#_preloads) environment variable.
You can load a whole file with `load-file`:

```sh
export BABASHKA_PRELOADS='(load-file "preload.clj")'
```

Most often the feature I want available by default is [hashp](https://github.com/weavejester/hashp)'s `#p` reader macro, which we can ensure is loading using this code:

```clojure
(require '[babashka.deps :as deps])
(deps/add-deps '{:deps {mvxcvi/puget {:mvn/version "1.3.4"}
                        hashp/hashp {:mvn/version "0.2.2"}}})
(require 'hashp.core)
```
