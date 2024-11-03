# .zshenv is loaded for all shells, including Vim

I had two scripts, `c` and `p`, that only served as aliases for `pbcopy` and `pbpaste`, respectively, both scripts having a comment that a script was needed because Vim didn't know about shell aliases.
Turns out Vim does know about shell aliases, I was just creating the aliases in `.zshrc`, which is only loaded for interactive shells.
[Moving the aliases](https://stackoverflow.com/questions/4642822/how-to-make-bashrc-aliases-available-within-a-vim-shell-command#comment32725637_4642855) to `.zshenv` made them accessible in vim `!` commands, in particular `:r!p` (paste the clipboard into the buffer) and `:%!c` (copy the buffer to the clipboard).
