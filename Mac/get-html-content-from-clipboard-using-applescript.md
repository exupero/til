# Get HTML content from clipboard using AppleScript

A coworker got unexpected formatting when he pasted some content from Slack into a WYSIWYG web editor, which in my experience has caused by pasting HTML content with its own styling info, and solved by pasting the content into Vim or another plain-text editor, then copying the result to get the original without HTML styling.
In this case, I was curious to see the HTML content, and [this answer](https://superuser.com/a/1673937) showed an AppleScript command:

```
osascript -e 'the clipboard as record'
```

The output began with `«class HTML»:«data HTML3C...`, followed by a large chunk of hexadecimal digits, followed by `», «class utf8»:...` and the plain-text content.
To decode the content, ChatGPT showed me Python's built-in `binascii` module, which has an `unhexlify` function; see the full details in [this script](https://github.com/exupero/scripts/blob/main/pbpastehtml).
