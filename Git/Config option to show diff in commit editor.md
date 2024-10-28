# Config option to show diff in commit editor

When committing to Git, I've been using a script that invokes `git commit` with the `-v` option ("verbose").
That causes Git to open $EDITOR with a diff of all the changes that are being committed.
It won't include the diff as part of the commit message, but I've found it's sometimes handy to have the diff available when writing the commit message, especially when there are notes to make about some of the changes.

I tried including a diff as part of a `prepare-commit-msg` hook, but even when adding in the marker line that Git seems to use to know when to stop reading the commit message (which looks something like this `# ----------- >8 -----------`), Git still included the diff.
I think without the `-v` option Git doesn't look for that marker.

Fortunately, there's another way: a [Git config option to always open $EDITOR in verbose mode](https://stackoverflow.com/a/37848889):

```sh
git config commit.verbose true
```
