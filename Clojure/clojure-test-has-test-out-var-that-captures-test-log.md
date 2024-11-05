# clojure.test has `*test-out*` var that captures test log

I tried [Rich Comment Tests](https://github.com/matthewdowney/rich-comment-tests/tree/main) for running test assertions in Clojure comments, and invoking it from [Conjure](https://github.com/Olical/conjure) using a [Babashka](https://babashka.org/) nREPL I didn't get the text output I expected from `clojure.test`.
All I got from a call to `run-ns-tests!` was a hash-map with how many tests passed and failed.

Digging into the code I found [this macro](https://github.com/matthewdowney/rich-comment-tests/blob/main/src/com/mjdowney/rich_comment_tests.clj#L367-L379), which taught me that `clojure.test` writes its text summary to the dynamic var `*text-out*`.
This code printed the text output I expected:

```clojure
(binding [clojure.test/*test-out* *out*]
  (com.mjdowney.rich-comment-tests/run-ns-tests! *ns*)))
```
