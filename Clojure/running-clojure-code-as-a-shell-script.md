# Running Clojure code as a shell script

While you can run a file of Clojure code with the shebang `#!/usr/bin/env clj -M`, I wasn't able to provide an `-Sdeps '{...}'` argument without getting a parsing error.
Eric Normand provides a [clever workaround](https://gist.github.com/ericnormand/6bb4562c4bc578ef223182e3bb1e72c5).
It takes advantage of the fact that `#` starts a shell comment, and `#_` comments out a Clojure form.
A full explanation is in [this comment](https://gist.github.com/ericnormand/6bb4562c4bc578ef223182e3bb1e72c5?permalink_comment_id=2951866#gistcomment-2951866), but essentially it runs a shell script embedded within a Clojure comment, and the shell script ends by calling [`exec`](https://github.com/exupero/til/blob/main/Unix/exec-replaces-current-process.md) to replace the current process with one that runs the file with Clojure.
