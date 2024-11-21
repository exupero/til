# 'gh alias set' can run shell commands

After moving some custom scripts for calling the GitHub API to [`gh` aliases](https://github.com/exupero/til/blob/main/GitHub/cli-commands-for-common-needs.md), I still had one script that I couldn't translate into a `gh` command.
I checked the docs for `gh alias` again and noticed the `--shell`/`-s` option, which allows making an alias out of a shell command, which was exactly what I needed to make the remaining script fit into the `gh` mold.
