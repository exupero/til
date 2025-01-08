# Slice array with `jq`

While browsing a large JSON object with [qq](https://github.com/JFryy/qq) (which provides an interactive interface to [jq](https://jqlang.github.io/jq/)), I wanted to get a couple adjacent items from a list.
On a whim I tried Python's slicing syntax, e.g. `items[5:7]`, and discovered that it worked.
Full documentation [here](https://jqlang.github.io/jq/manual/#array-string-slice).
