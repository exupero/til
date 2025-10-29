# Diff directories

For a while I've had a problem that occasionally arises with a project, and I've solved it by deleting a generated directory.
I finally looked into the source of the problem and diffed a working version of the directory against a broken one.
To do that I used the CLI command [`diff -bur [dir1] [dir2]`](https://stackoverflow.com/a/2019897) ([man page](Unix/diff-directories-with-diff-r-.md)), which gave me lines for files that were missing in one directory but present in the other, as well as diffs of files that were in both but not the same.
The `-r` option triggers recursive diffing through subdirectories, `-b` ignores whitespace differences, and `-u` gives a unified diff format.
I also used this when I had two very similar project directories, but only one of them was working as expected, in which case I also used the `-x` flag several times to exclude subdirectories I didn't care about, such as `.git` and `node_modules`.
