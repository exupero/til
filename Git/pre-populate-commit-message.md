# Pre-populate commit message

Learning about Git hooks this morning, I stumbled across the `prepare-commit-msg` hook, which allows customizing the initial commit message, which you can use to [include a Jira reference](https://mincong.io/2019/07/23/prepare-commit-message-using-git-hook/) extracted from the branch name.

For the last several years I've been using a script to do that, via the `-t/--template` option to `git commit`:

```sh
#!/bin/sh

git commit -t <(git rev-parse --abbrev-ref HEAD | grep -o '\(JIRA\)-[0-9]\+') $*
```

Instead of a script, here's a `prepare-commit-msg` hook:

```sh
#!/bin/sh

COMMIT_MSG_FILE=$1
COMMIT_SOURCE=$2
SHA1=$3

# Only add custom message when there is no commit source
# ($COMMIT_SOURCE is empty). Otherwise, keep the default message
# proposed by Git. Possible commit source: message, template,
# merge, squash or commit. See https://git-scm.com/docs/githooks
if [[ -z "$COMMIT_SOURCE" ]]; then
  ref=$(git branch --show-current)
  if [[ $ref =~ ^.*((JIRA)-[0-9]+).* ]]; then
    hint=$(cat "$COMMIT_MSG_FILE")
    ticket="${BASH_REMATCH[1]}"
    cat > "$COMMIT_MSG_FILE" << EOF
$ticket 
$hint
EOF
  fi
fi
```

It's more verbose but handles some situations I've been handling manually, such as not calling the script when doing a merge or squash, and using a hook means I no longer have to remember to invoke a separate script.
