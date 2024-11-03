# Force output to be colored

When running a Git command in the terminal, output is colored using ANSI escape sequences, but when running the same command from a script, the output has no escape sequences.
I was working on a script that invokes Git to show the status of several Git repos, and I wanted those statuses to show the way I was used to seeing them, with colors.
To get the ANSI escape sequences, [this answerl](https://stackoverflow.com/a/18304605) showed the trick: before the subcommand, include `-c config.ui=always`.
For example:

```sh
git -c config.ui=always status --short
```

The [`-c` option](https://git-scm.com/docs/git#Documentation/git.txt--cltnamegtltvaluegt) overrides the value of a config field just for that command.
