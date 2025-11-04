# Filter Pytest tests with boolean logic

[Pytest](https://pypi.org/project/pytest/) only accepts one `-m` option to specify which marks to run, so if you want to run tests marked differently in a single command, use `or`, i.e. `pytest -m 'unit or integration'`.
You can also use `not` and `and`, as well as combine operators, e.g. `integration and not slow`.
