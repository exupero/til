# Pull with --rebase gets forced pushes

I occasionally amend Git commits and force push, and though I usually sneak it in before anyone has pulled the amended commit, every now and then someone pulls the commit before it's amended, causing my force push to leave them stranded on a ref that's no longer on the branch.
To solve that, I've usually recommended deleting the branch and re-fetching it.

The other day I caused this problem for myself using two different laptops, and by a fluke of muscle memory I found a better solution.
I have a [shell alias](https://github.com/exupero/scripts/blob/main/git-aliases.sh#L13) for [`git pull --rebase`](https://git-scm.com/docs/git-pull#Documentation/git-pull.txt---rebasefalsetruemergesinteractive), which I use when I've committed locally and there are new commits on the remote that I want to replay my local commits on top of.
But it turns out that it also works for commits that have been force pushed.
Even without local commits to replay, `git pull --rebase` pulls the new remote commits and updates the local branch, reconciling the divergent branches.
