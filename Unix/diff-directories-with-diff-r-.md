# Diff directories with `diff -r`

I had two very similar project directories, but only one of them was working as expected.
To hunt down the problem, I found that the [`diff` command has an `-r` option](https://www.man7.org/linux/man-pages/man1/diff.1.html) for recursively diffing directories.
I added the `-x` option several times to exclude subdirectories I didn't care about, such as `.git` and `node_modules`.
With it, I was able to identify a difference in my `package.json` that led me to why one project worked and the other didn't.
