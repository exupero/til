# Search hidden files with ripgrep

By default I use [ripgrep](https://github.com/BurntSushi/ripgrep) to search files.
I use it from the shell, [fzf.vim](https://github.com/junegunn/fzf.vim) uses it, and I have an `:Rg` command in my Neovim config to populate the quicklist from an `rg` command.
But one annoyance has been that `rg` doesn't search hidden files.
Anytime I had edit a .gitignore or .eslintrc or any other dotfile in a repo, `:FZF` wouldn't show it and I'd have to navigate to it manually with `:edit` or `:find`.

[This comment](https://github.com/junegunn/fzf/issues/634#issuecomment-517716913) gave me the key to a solution: add the `--hidden` option.
`fzf.vim` can be fixed by setting the environment variable `FZF_DEFAULT_COMMAND` to e.g. `rg --hidden --files`, but that only fixes the `:FZF` command in Neovim.
To fix it everywhere, you can use a [Ripgrep config file](https://github.com/BurntSushi/ripgrep/blob/master/GUIDE.md#configuration-file): set the env var `RIPGREP_CONFIG_PATH` to a file that specifies always including `--hidden`.
(Consequently, as shown in the example config, it may also be important to include `--glob=!.git/*` so searching hidden files doesn't include Git files.)
