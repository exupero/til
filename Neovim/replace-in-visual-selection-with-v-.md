# Replace in visual selection with `\%V`

Today I needed to remove spaces within a string.
The substitution command `:s,\s\+,,g` will remove all spaces on the current line, not within what's visually selected.
To limit the substitution to just what's visually selected (or what would be reselected by `gv`), you can use the `\%V` operator, like this:

```
:s,\%V\s\+,,g
```

For more info, see `:help \%V`.
