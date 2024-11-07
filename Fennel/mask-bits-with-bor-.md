# Mask bits with `bor`

[This demo](https://gist.github.com/heptal/7e578c3129012f0e7e91965bb1f2010e) of Hammerspoon's webview used the Lua expression `1|2|4|8`.
Most of my Hammerspoon config is in [Fennel](https://fennel-lang.org/), but I couldn't find the function that would mask bits like this.
[Clojure](https://clojure.org/)'s function is named [`bit-or`](https://clojure.github.io/clojure/clojure.core-api.html#clojure.core/bit-or), but rather than search blindly for something similar, I used [this transpiler](https://fennel-lang.org/see) to convert the Lua expression into the equivalent Fennel, which gave me `(bor 1 2 4 8)`.

In that transpiler, the Lua code `1|2|4|8` doesn't parse on its own, so I used `return 1|2|4|8`, which gave me the result I needed.
