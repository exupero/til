# Meander rewrite forms can recurse using meander.epsilon/app

I'm working on a small project to translate Clojure forms into Python ASTs, and after writing some branchy tree-walking code that quickly became unpleasant, I took a deeper dive into [Kalai](https://github.com/kalai-transpiler/kalai)'s code.
Kalai transpiles Clojure into Rust, C++, and Java by making several small transformation passes using [Meander](https://github.com/noprompt/meander)'s pattern matching and term rewriting, and while I've played with Meander before, I mostly recursed by invoking `meander.strategy.epsilon/bottom-up`.
In this project I couldn't use blanket recursion, each rewrite needed to control recursion differently.
Using a `meander.strategy.epsilon/match` form worked trivially, but I had trouble with `meander.strategy.epsilon/rewrite`, which uses substitution patterns.
I monkeyed around with quoting and unquoting without success, then took a closer look at Kalai's Java transformations, where I discovered [this code](https://github.com/kalai-transpiler/kalai/blob/main/src/kalai/pass/java/a_syntax.clj#L85-L92) that uses `meander.epsilon/app` to apply a function to pattern.
It worked perfectly.

To see the code and more details, check out [this module](https://github.com/exupero/bblib/blob/main/python.clj).
