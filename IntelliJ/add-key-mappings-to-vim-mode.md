# Add key mappings to vim-mode

I've used the vim-mode extension in IntelliJ for a long time, and just today learned from [this answer](https://stackoverflow.com/a/50359985) that I can add key mappings by creating a `~/.ideavimrc` file.
I added mappings to jump to the next and previous error:

```
nnoremap ]d :action GotoNextError<CR>
nnoremap [d :action GotoPreviousError<CR>
```
