# Move shell cursor with `tput` command

I had a script whose output I wanted to refresh every few seconds, and rather than re-build the script with a more capable TUI framework than just printing to stdout, I found the `tput` command.
`tput` can move the terminal cursor to different points on the terminal window.

Since I wanted to replace the output of the script with new output every few seconds, I didn't want to use `tput move`, which moves the cursor to an absolute position on the screen.
`tput sc` (save cursor) and `tput rc` (restore cursor) also work with absolute position, and while they were easy to add they didn't do quite the right thing when the script's output caused the terminal window to scroll.

Instead, I used `tput cuu N`, where `cuu` means "cursor up" and `N` is the number of lines to move upward.
To use it, I did have to capture the script's original output and count the number of lines, print it, then move up by that number of lines, but that was easy enough for my purposes.

There is trouble when the line length is wider than the terminal and the line wraps, in which case counting the number of lines returns fewer than the actual number of terminal lines and the cursor only moves partway up the script's output.
