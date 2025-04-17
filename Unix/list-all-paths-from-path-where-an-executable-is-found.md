# List all paths from $PATH where an executable is found

I used `brew` to install a replacement for a binary that was pre-installed on my Mac, but `which` still returned the pre-installed file, even after starting a new terminal.
To find where `brew` had installed the file I tried `brew info`, but it showed the path of the executable in Homebrew's cellar directory, not the path in `$PATH` where the executable would be found if I didn't have the pre-installed version.
I tried moving the pre-installed binary, but it wouldn't budge, even with `sudo`.

I ended up using `type -a` with the name of the executable, which listed all the directories on `$PATH` that had an executable of the given name.
It showed some directories more than once, apparently because I have those directories multiple times in my `$PATH`.
