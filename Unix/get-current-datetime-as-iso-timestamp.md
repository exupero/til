# Get current datetime as ISO8601 timestamp

In Bash the `date` command has the option `-I` for showing the current date in ISO8601 format, e.g. `2025-04-09`.
To get greater precision than just the date, the [man page](https://www.man7.org/linux/man-pages/man1/date.1.html) notes that you can specify `hours`, `minutes`, or `seconds`, e.g. `date -Iseconds`.
Some versions of `date` appear to support an `ns` option as well (as indicated by the linked man page), but the default `date` I have on my Mac doesn't.
