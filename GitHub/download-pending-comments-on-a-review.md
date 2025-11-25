# Download pending comments on a review

Review a large PR, I'd added a couple dozen comments to a pending review, but possibly because of the size of the PR GitHub's UI stopped showing both the comments and the total count of pending comments in the "Submit review" button.
That gave me a scare, but I found the comments still showed on the "Conversation" tab.
Since the list of comments under the "Submit review" button didn't show, I worried that submitting the review wouldn't submit all the existing comments, so I figured out how to download the pending comments using the `gh` CLI tool.

I got the list of reviews on the PR with a command like this:

```bash
gh api repos/{owner}/{repo}/pulls/{number}/reviews
```

Then I found my `PENDING` review and got its ID to use in the command:

```bash
gh api repos/{owner}/{repo}/pulls/{number}/reviews/{id}/comments
```

That produced a JSON array of all my comments that I saved to my local machine in case I needed to recreate the comments later.

I ran that command every few files I reviewed, and checked that the total number of comments was increasing by piping the JSON output to `jq length`.
At one point it stuck at 30 comments, but it turned out to be due to pagination.
I got all the comments by adding the `--paginate` option:

```bash
gh api repos/{owner}/{repo}/pulls/{number}/reviews/{id}/comments --paginate
```
