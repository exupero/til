# Bash has `$'...'` syntax

I copied a cURL command from Chromium today and noticed that the value given to the `--data-raw` option was a single-quoted string but prefixed by `$`.
[This comment](https://unix.stackexchange.com/questions/48106/what-does-it-mean-to-have-a-dollarsign-prefixed-string-in-a-script#comment1317142_48122) explains that `$'...'` allows escaping newlines and single quotes inside a single-quoted string, which will otherwise use literal backslashes rather than the escaped characters.
This is a much easier way to escape single quotes than the incantation `'"'"'`.