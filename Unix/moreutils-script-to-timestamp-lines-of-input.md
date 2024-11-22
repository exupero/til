# moreutils script to timestamp lines of input

I started writing a script I wanted to name `ts`, but first I ran `which ts` to see if the name was already used, and it was.
`man ts` describes it as a [moreutils](https://joeyh.name/code/moreutils/) script that adds a timestamp to each line of input, which I quickly confirmed with

```bash
while; do echo now; sleep 1; done | ts
```
