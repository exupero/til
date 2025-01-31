# Drop lines from beginning of stdin

To drop lines from the beginning of stdin, you can use `tail`, just give the `-n` option a number prefixed by `+`, e.g. `tail -n +7`.
It's documented in the [man page](https://www.man7.org/linux/man-pages/man1/tail.1.html).
