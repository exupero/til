# `preexec` hook to log commands

I went searching for a shell command I'd run a few weeks ago but didn't remember, and unfortunately it was too long ago to be among my last 1000 commands, stored in `~/.zsh_history`.
To create a more comprehensive history, I added a Zsh `preexec` hook to log shell commands to SQLite.
The history includes a timestamp, the directory where the command was run, and the name of the Tmux session it was run in:


```zsh
COMMAND_HISTORY_PATH=$HOME/.commands.db

sqlite3 $COMMAND_HISTORY_PATH <<EOF
CREATE TABLE IF NOT EXISTS commands (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  command TEXT NOT NULL,
  timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
  directory TEXT NOT NULL,
  session TEXT
);
EOF

log_command() {
  if [[ -n "$1" ]]; then
    local escaped_command=$(echo "$1" | sed "s/'/''/g")
    local session=$(tmux display-message -p '#S')
    sqlite3 $COMMAND_HISTORY_PATH <<EOF
INSERT INTO commands (command, timestamp, directory, session)
VALUES ('$escaped_command', datetime('now'), '$PWD', '$session');
EOF
  fi
}

autoload -Uz add-zsh-hook
add-zsh-hook preexec log_command
```

This isn't battle-tested, but it's been working so far.
Some improvements would be to exclude certain common commands (e.g. `git status -s`) and add a mechanism to prevent a command from being logged (e.g. [by prepending a space](https://github.com/jbranchaud/til/blob/master/unix/exclude-a-command-from-the-zsh-history-file.md)).
