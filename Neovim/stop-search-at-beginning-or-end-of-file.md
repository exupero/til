# Stop search at beginning or end of file

I've been editing a lot of files recently, reducing the uses of certain words, and I wanted to know when I'd hit the end of the document.
By default when a Vim a search hits the end of a document it continues searching from the beginning, which while handy when working in code wasn't what I needed in this case, where hitting the end of the document signaled to move on to the next file.

To change this behavior, [this answer](https://stackoverflow.com/a/10854493) pointed me to the `set nowrapscan` option, which stops search from wrapping at both the beginning and end of the document.
