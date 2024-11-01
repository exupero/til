# Random output needs to check snip.c

[UltiSnips](https://github.com/SirVer/ultisnips) runs a snippet for every cursor movement, so when the output of a snippet is random, the snippet's code needs to check `snip.c` to avoid resetting the output on interaction.
See [this thread](https://answers.launchpad.net/ultisnips/+question/188234) for more info.

I was tipped off to this by an error when running this snippet:

```snippets
snippet uuid "Insert a random UUID" b
`!p import uuid
snip.rv = str(uuid.uuid4())`
endsnippet
```

To fix it, I added `if not snip.c`:

```snippets
snippet uuid "Insert a random UUID" b
`!p import uuid
if not snip.c:
    snip.rv = str(uuid.uuid4())`
endsnippet
```
