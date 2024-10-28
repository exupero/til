# CLI commands for common needs

I'd forgotten about [Github's CLI tool `gh`](https://cli.github.com/), but [this TIL](https://github.com/jbranchaud/til/blob/master/workflow/view-the-pr-for-the-current-github-branch.md) reminded me of it, and I discovered it has some commands for operations I'd written my own scripts for:

- [`gh browse`](https://cli.github.com/manual/gh_browse)
- [`gh pr status`](https://cli.github.com/manual/gh_pr_status)
- [`gh pr view --web`](https://cli.github.com/manual/gh_pr_view)
- [`gh pr comment --body ...`](https://cli.github.com/manual/gh_pr_comment)

I've now deleted those scripts and added [`gh` aliases](https://cli.github.com/manual/gh_alias) for the longer ones.

On my Mac, aliases are stored in `~/.config/gh/config.yml`, which makes it easy to move that file to my dotfiles folder and symlink to it.
