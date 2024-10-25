# Put file's name in register

I've looked [this](https://stackoverflow.com/a/954336) up before and don't seem to need it enough to make it muscle memory, but you can put the current file's path on the system clipboard with `:let @" = expand('%')`.
That uses Vim's unnamed register, `@"`, but you can use other registers as well, e.g. `@a`.
You can put any text in a register this way, including literal text or the result of more complicated Vimscript expressions.
