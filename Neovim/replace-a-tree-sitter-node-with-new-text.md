# Replace a tree-sitter node with new text

I wanted some logic that would replace the current tree-sitter node with some new text.
Here's a two-line function to do so, in [Fennel](https://fennel-lang.org/):

```fennel
(fn replace-node [node replacement]
  (let [(start-row start-col end-row end-col) (node:range)]
    (vim.api.nvim_buf_set_text 0 start-row start-col end-row end-col [replacement])))
```
