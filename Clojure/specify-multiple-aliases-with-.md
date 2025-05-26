# Specify multiple aliases with ':'

Working on a deps.edn project, I wanted to use multiple aliases, specifically one for development that added [Portfolio](https://github.com/cjohansen/portfolio) and one that used a local checkout of a dependency.
I tried using the alias flag multiple times, but only the last one seemed to take effect.
[This page](https://practical.li/clojure/clojure-cli/defining-aliases/#clojure-exec-tool) indicated that I could merge multiple aliases together by separating them with a colon, e.g. `clojure -M:dev:local`.
This particular project is using [shadow-cljs](https://github.com/thheller/shadow-cljs), so I used `npx shadow-cljs watch app portfolio -A dev:local`, which worked as desired.
