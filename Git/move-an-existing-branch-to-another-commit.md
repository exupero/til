# Move an existing branch to another commit

I'd made several commits on my `main` branch before I decided to move the work to a branch and put `main` back where it was.
[This StackOverflow answer](https://stackoverflow.com/a/5471197) showed how:

```sh
git branch --force main <commit>
```
