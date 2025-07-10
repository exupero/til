# '*' and '/' syntax for specifying positional and keyword argument requirements

Python's syntax for splatting arguments uses an asterisk followed by a variable name that will hold the splatted values, e.g., `def example(*args):`.
A couple years ago I encountered an asterisk without a name following it, e.g., `def example(a, *, b, c):`, which requires arguments after the asterisk to be passed as keyword arguments, e.g., `example(1, b=2, c=3)`.
Calling it as `example(1, 2, 3)` will raise a TypeError.
Arguments before the asterisk may also be passed as keyword arguments, but may be positional.

A few days ago I saw a bare slash in an argument list, e.g., `def example(a, /, b, c):`.
According to [this](https://realpython.com/python-asterisk-and-slash-special-parameters/), that disallows arguments before the slash from being passed as keyword arguments, and allows arguments after the slash to be either positional or keyword arguments.
Calling it as `example(a=1, b=2, c=3)` will raise a TypeError.
