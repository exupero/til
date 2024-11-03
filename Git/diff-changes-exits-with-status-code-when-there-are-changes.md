# Diff --changes exits with status code 1 when there are changes

I copied [this GitHub Actions step](https://github.com/exupero/til/blob/main/.github/workflows/build.yml#L26) from [Simon Willison's](https://github.com/simonw/til/blob/main/.github/workflows/build.yml#L103), but I didn't notice one detail of it until I implemented [a Clojure function](https://github.com/exupero/bblib/blob/main/git.clj#L36-L38) to detect if a repo had changes.
Here's the line:

```sh
git diff --quiet || (git add README.md && git commit -m "Updated README")
```

Note that it uses the shell's OR syntax, `||`, which mean that the commands on the right side are only run if the command on the left side produces a positive exit code.
According to the docs, [`git diff --quiet`](https://git-scm.com/docs/git-diff#Documentation/git-diff.txt---quiet) implies the [`--exit-code`](https://git-scm.com/docs/git-diff#Documentation/git-diff.txt---exit-code) option (otherwise there would be no output or side effects), and `--exit-code` produces a 1 when there are changes and 0 when there aren't any.

That's a reasonable choice of behavior, but it does make the shell code a bit less intuitive.
Rather than higher-level semantics like "there are changes AND make a commit", you have to know the low-level details of what exit codes are produced and what shell syntax will evaluate the right-hand side of the expression at the right times.
