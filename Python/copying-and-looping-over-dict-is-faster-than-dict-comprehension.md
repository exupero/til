# Copying and looping over dict is faster than dict comprehension

I encountered a function that copied a dictionary and called a function on any keys that matched a predicate, something like this:

```python
def splat_and_loop(d):
    updated = {**d}
    for key, value in updated.items():
        if value % 3 == 0:
            updated[key] = str(value)
    return updated
```

The same thing can be done with a dictionary comprehension, which I prefer syntactically for reasons I've described [here](https://blog.exupero.org/an-advantage-of-python-comprehensions/):

```python
def dict_comprehension(d):
    return {key: str(value) if value % 3 == 0 else value
            for key, value in d.items()}
```

I expected the dictionary comprehension to be faster, since it doesn't have to iterate over the dictionary twice (once when splatting into a new dictionary, and again to look for values matching the predicate).
To compare performance of the two versions, I used the built-in `timeout` module:

```python
import timeit

def run(n):
    data = {i: i for i in range(100)}
    time1 = timeit.timeit(lambda: splat_and_loop(data), number=n)
    print(f"Splat and loop: {time1:.6f}s")
    time2 = timeit.timeit(lambda: dict_comprehension(data), number=n)
    print(f"Dict comprehension: {time2:.6f}s")

run(1000000)
# Splat and loop: 3.861252s
# Dict comprehension: 4.520006s
```

The original version is faster!
I'm guessing that while `{**d}` looks like a splat that iterates over the dictionary, it's actually performed as a single copy operation in C that's faster than creating and modifying a new dictionary in interpreted Python code.
