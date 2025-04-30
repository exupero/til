# Parse sequence of JSON values with cheshire.core

I was contemplating how, with Clojure, to parse a series of JSON values from a string when they don't have any delimiters between values.
[Cheshire](https://github.com/dakrone/cheshire)'s [`parse-stream`](https://github.com/dakrone/cheshire/blob/64c77b8173b6788766fac868506a35ce713972c5/src/cheshire/core.clj#L238) only reads one value, but I eventually found [`parsed-seq`](https://github.com/dakrone/cheshire/blob/64c77b8173b6788766fac868506a35ce713972c5/src/cheshire/core.clj#L326), which does what I was looking for.
For example, `(cheshire.core/parsed-seq "{} 3.2 {\"a\": 2} 1 2 true false [] null")` returns `({} 3.2 {:a 2} 1 2 true false [] nil)`
