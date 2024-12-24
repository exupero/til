# List keymappings and their origins

I have some Neovim plugins whose keymaps conflict, and to troubleshoot them I learned from [these StackOverflow answers](https://stackoverflow.com/questions/7642746/is-there-any-way-to-view-the-currently-mapped-keys-in-vim) that the commands `:nmap`, `:imap`, and `:vmap` will list all keypmappings for normal, insert, and visual mode, respectively.
To list where each keymapping was set, prefix the command with `:verbose`, e.g. `:verbose imap`.
You can also ask for a specific keymap, e.g. `imap <tab>` or `imap <c-n>`.
