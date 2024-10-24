# Set env var in running instance

I started splitting my private Babashka libraries into a repo I can make public and updated my `BABASHKA_CLASSPATH` environment variable to include the new location.
Unfortunately, a running instance of Neovim already had the old env var, and it had enough work in progress that I didn't want to kill it (I forgot about [`:mksession`](https://stackoverflow.com/a/1642641)).
It didn't work to suspend Neovim with Ctrl+Z, set the env var in the shell, then resume Neovim.
[This StackOverflow answer](https://stackoverflow.com/a/64577833) had the solution: run `:let $BABASHKA_CLASSPATH="{new classpath here}"`.
