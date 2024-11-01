# Close all splits except the current one

[vim-medieval](https://github.com/gpanders/vim-medieval/tree/master) opens a split when `:EvalBlock` is called without an argument or any target blocks, and each invocation opens a new split, prompting me to look for a quick way of closing splits without switching the cursor to each split and running `:q`.
[This SO answer](https://stackoverflow.com/a/4810928) gave me what I needed: `:only` (or just `:on`), `<C-w>o`, and `<C-w><C-o>`.
