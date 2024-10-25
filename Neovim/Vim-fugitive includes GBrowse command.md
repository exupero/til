# vim-fugitive includes GBrowse command

Thanks to [this TIL](https://github.com/jbranchaud/til/blob/master/vim/view-the-current-file-in-github.md) I learned about [vim-fugitive](https://github.com/tpope/vim-fugitive)'s `:GBrowse` command.
I'd written a script for the same functionality, which I called from a Vim function, but `:GBrowse` obviates the need for it.

To function, the command does require an additional plugin to open files on a specific Git platform.
For GitHub, it's [vim-rhubarb](https://github.com/tpope/vim-rhubarb).
