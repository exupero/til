# Pre-commit hook to check for text in changed files

I've started moving some of my workflow code from private repos to public ones, and part of that process is making sure the public repos don't hard-code paths to locations on my local filesystem.
To help protect against that, I added [this Git pre-commit hook](https://stackoverflow.com/a/54285525) that stops the commit when it contains certain text:

```shell
#!/bin/sh

declare -a arr=("some text")

for i in "${arr[@]}"; do
  git diff --cached --name-only | xargs grep --with-filename -n $i && echo "COMMIT REJECTED! Found '$i' references. Please remove them before commiting." && exit 1
done

exit 0
```

To enable it, call the script from the repo's `.git/hooks/pre-commit` script.

This has to be configured separately in each checkout of a repo.
