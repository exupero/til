# Fix treesitter error when viewing :help

I started getting treesitter parser errors anytime I used `:help`, and I found the solution in [this thread](https://github.com/LunarVim/LunarVim/issues/3680).
A lot of people fixed it with a blanket `:TSInstall all`, but I only needed `:TSInstall vimdoc`.
