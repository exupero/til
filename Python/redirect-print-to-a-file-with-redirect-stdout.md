# Redirect print to a file with redirect_stdout

I wanted to redirect some specific `print` logging in a script to instead write to a file.
It's easy enough to call `file.write()` instead of `print()`, or even `print(..., file=file)`, but I wanted a technique that minimized the number of code changes and kept them in one place.
I found [`contextlib.redirect_stdout`](https://docs.python.org/3.13/library/contextlib.html#contextlib.redirect_stdout).
Rather than changing any calls to `print`, you can wrap the top of the call tree you want to redirect in a `with` statement:

```python
with open('help.txt', 'w') as f:
    with redirect_stdout(f):
        ...
```

The necessary changes are relatively non-invasive, though you'll have to indent the code you want wrapped.
