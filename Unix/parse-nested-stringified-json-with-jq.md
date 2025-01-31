# Parse nested, stringified JSON with jq

I occasionally have to deal with JSON structures that have, embedded inside them, strings of serialized JSON.
Using [`jq`](https://jqlang.github.io/jq/) from the command line I've been doing something like this: `cat data.json | jq -r .field | jq`.
The `-r` option prints the value as text rather than JSON, which I then parse with another invocation of `jq`.

Today I learned you can do this without calling `jq` again by using the [`fromjson`](https://jqlang.github.io/jq/manual/#convert-to-from-json) operator: `cat data.json | jq '.field | fromjson'`.
You can also update the field in place using `|=`: `cat data.json | jq '.field |= fromjson'`.
