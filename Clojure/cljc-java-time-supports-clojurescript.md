# cljc.java-time supports ClojureScript

I've always used [cljs-time](https://github.com/andrewmcveigh/cljs-time) for doing date and time operations in ClojureScript, but today I ran into [this problem](https://github.com/andrewmcveigh/cljs-time/issues/133) without how days are counted across daylight savings starting.
Looking around for alternatives, I found [cljc.java-time](https://github.com/henryw374/cljc.java-time), which I've used from [Babashka](https://babashka.org/) but hadn't realized supported the exact same Clojure API in ClojureScript, even though it's obvious from the library name.
I switched the code over from cljs-time to cljc.java-time without trouble, and without the daylight savings bug.
