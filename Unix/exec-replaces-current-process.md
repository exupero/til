# `exec` replaces current process

The Unix command [`exec`](https://www.geeksforgeeks.org/exec-command-in-linux-with-examples/) replaces the process that invoked it with a process running the command it was given.
For example, `exec bash -c "echo starting"; echo Done` will print "starting" but not "done".

