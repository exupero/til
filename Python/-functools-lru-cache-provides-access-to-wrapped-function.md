# `functools.lru_cache` provides access to wrapped function

Python provides a function decorator for memoizing functions via the [`functools.lru_cache`](https://docs.python.org/3.14/library/functools.html#functools.lru_cache) function.
Today I learned you can access the wrapped function using the decorator's `__wrapped__` attribute:

```python
import functools

@functools.lru_cache
def example():
    print('hello')
    return 2

example() # prints "hello"
example() # doesn't print "hello"
example.__wrapped__() # prints "hello"
```

I didn't find that I could monkeypatch a new function into the decorator by setting `__wrapped__` to a different function.
The docs say the attribute "is useful for introspection, for bypassing the cache, or for rewrapping the function with a different cache", so it appears to be a read-only type of attribute.
