# Submit patch hunk with single key

I use [`git add -p`](https://git-scm.com/docs/git-add#Documentation/git-add.txt--p) most of the time to review my changes as I stage them, and sometimes to omit a hunk or edit it before staging it.
I'd wondered recently why I should have to press Enter after every selection, given that the directives for staging, skipping, or editing a hunk are all single characters.
Coincidentally, [this TIL](https://github.com/jbranchaud/til/blob/88e675b9a33e5ab3c1569c291f1ca557755d05f0/git/better-diffs-with-delta.md) showed me that Git has an option for that:

```
git config interactive.singleKey true
```

It takes a little getting used to.
My muscle memory hasn't yet adjusted to not having to press Enter, but in time it will.
