# Vim-medieval configuration to run Clojure code with Babashka

[Vim-medieval](https://github.com/gpanders/vim-medieval/tree/master) allows you to run fenced code blocks in Markdown files.
It uses the name after the triple backticks to invoke an interpreter, but you have to specify what interpreters are allowed by setting `g:medieval_langs`.
I typically run Clojure code via [Babashka](https://babashka.org/), so for `clojure` blocks I wanted to invoke `bb` instead of `clojure`, and vim-medieval [provides a way](https://github.com/gpanders/vim-medieval/blob/master/doc/medieval.txt#L293-L300):

```
let g:medieval_langs=['clojure=bb']
```

Note that unlike evaluating Clojure forms via an nREPL, vim-medieval only shows what's printed to stdout.
