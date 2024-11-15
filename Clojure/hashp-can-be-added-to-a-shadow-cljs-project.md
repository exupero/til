# hashp can be added to a shadow-cljs project

I've been using [hashp](https://github.com/weavejester/hashp) in [Babashka](https://babashka.org/) for several months.
It provides a `#p` reader macro that prints both the next form and the value it evaluates to, and is both more helpful and easier to add and remove than the alternative I would otherwise use, `(doto ... prn)`.

This week I've been writing ClojureScript using [shadow-cljs](https://github.com/thheller/shadow-cljs), and I missed the ease of debugging with `#p`.
It turns out [hashp supports shadow-cljs](https://github.com/weavejester/hashp?tab=readme-ov-file#shadow-cljs), and quite easily: just add `hashp/hashp` as a dependency, then configure the build in `shadow-cljs.edn` with the key-value pair `:devtools {:preloads [hashp.core]}`.
