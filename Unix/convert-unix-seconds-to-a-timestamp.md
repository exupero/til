# Convert Unix seconds to a timestamp

If you've got some number of seconds or milliseconds since the Unix epoch, you can convert them to a timestamp with the `date` utility.
Give the `-r` seconds since the epoch (so if you have milliseconds, drop 3 digits from the end).
For example,

```sh
date -r 1531699200
```

will output

```
Sun Jul 15 20:00:00 EDT 2018
```
