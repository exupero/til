# Pip install globally, regardless of active virtualenv

I wanted to play around with [Basilisp](https://basilisp.readthedocs.io/en/latest/), which is installed via `pip install basilisp`, but when working on a Python project I typically use [pyenv](https://github.com/pyenv/pyenv) with the [virtualenv plugin](https://github.com/pyenv/pyenv-virtualenv), in order to isolate dependencies between projects.
That meant a simple `pip install basilisp` installed it into a single environment and I had to install it everywhere I might use it.

The solution is to add the `--global-option=install` option to the `pip install` command, which made Basilisp available regardless of what virtual environment is currently active.
