# Edit and replay bisection

While running `git bisect`, I mistakenly hit "up" and "Enter" in my shell and resubmitted a `git bisect bad` without actually knowing the commit was bad.
Since I was several steps into the bisection and didn't want to start over, I found [this answer](https://stackoverflow.com/a/8594800) which shows how to save the current progress of the bisection and replay an edited version.

First run `git bisect log` and save the output to a file.
Then modify the file to remove the mistake.
Lastly, run `git bisect restart` and `git bisect replay [log file]`.
You should now be on the commit you were on before the mistake, which solved my problem.
