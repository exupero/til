# Specify default options to Pytest

[Pytest](https://pypi.org/project/pytest/) allows configuring an [addopts](https://docs.pytest.org/en/7.1.x/example/simple.html) field that provides default arguments to the `pytest` command.
Setting it to `-m unit` does indeed cause the `pytest` command to run only the unit tests.
I worried, however, that those added options would also be included when running `pytest -m integration`, but testing that command only ran the integration tests.
I inferred that the `addopts` field is only used when no options are provided, but the docs reveal differently and explain what's really going on: the addopts field is supplied first and later options (i.e. those provided on the command line) are provided later, with the later ones taking precedence over earlier ones.
Pytest only accepts one `-m` option, so the one provided on the command line overrides the one from `addopts`.

To run multiple marks in a single command, [use boolean logic](https://github.com/exupero/til/blob/main/Python/filter-pytest-tests-with-boolean-logic.md).
