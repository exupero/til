# Export all variables in a sourced script

The other day I saw a script that exported a set of environment variables in a file using `cat file.sh | xargs export`.
I tried that on a file with comments in it, which naturally didn't work.
Looking for an alternative that was more robust, I found the `set -a`/`set -o allexport` [option](https://www.gnu.org/software/bash/manual/html_node/The-Set-Builtin.html), which causes all subsequent variable and function definitions to be exported, including those sourced in a script.
`set +a`/`set +o allexport` will unset the option but leave all exported variables exported.
So instead of `cat file.sh | xargs export`, I could use `set -a; source file.sh; set +a`.

