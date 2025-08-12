# line-profiler library

I've occasionally had to find the slow parts of some Python code.
The simplest approach is to add a few lines of code around different expressions and log some time differences, like this:

```python
start = time.monotonic_ns()
print('hello!')
end = time.monotonic_ns()
print(f"print('hello!'): {(end - start)/1e6}ms")
```

I tire of that pretty quickly, so I'll often throw together a quick context manager:

```python
@contextlib.contextmanager
def timer(label):
    start = time.monotonic_ns()
    yield
    end = time.monotonic_ns()
    print(f"print('hello!'): {(end - start)/1e6}ms")
```

That lets me add timing code with a single line (but plus another level of indentation):

```python
with timer("print('hello!')"):
    print('hello!')
```

Embarking on such a task again, I wondered if I could use a decorator to instrument automatically the compiled bytecode of a function.
Fortunately, before I tackled such a problem, I looked for prior work and found [line-profiler](https://pypi.org/project/line-profiler/).
When a Python script is run with the `kernprof` script, any function or class decorated with `@profile` will be instrumented to collect profiling data.
`python -m line_profiler [some file].lprof` will show the number of hits on each instrumented line, and the total time spent executing each line.

Much better than my simple context manager!
