# Search PRs merged between two dates

I was doing some GitHub archaeology looking for PRs that might have broken the build, and I needed to find PRs that merged between two dates.
I guessed at the syntax for a few minutes and didn't guess right, but [this answer](https://stackoverflow.com/a/42929781) showed that the syntax is `merged:<start date>..<end date>`.

This [range syntax](https://docs.github.com/en/search-github/getting-started-with-searching-on-github/understanding-the-search-syntax#query-for-values-between-a-range) also works for fields besides dates, such as the number of stars.
