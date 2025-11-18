# `functools.lru_cache` decorator provides method to clear cache

Python provides a function decorator for memoizing functions via the [`functools.lru_cache`](https://docs.python.org/3.14/library/functools.html#functools.lru_cache) function.
Today I learned you can clear the cached values by calling the wrapped function's `.cache_clear()` method:

```python
import functools

@functools.lru_cache
def example():
    print('hello')
    return 2

example() # prints "hello"
example() # doesn't print "hello"
example.cache_clear()
example() # prints "hello"
```
