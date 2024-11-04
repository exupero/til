# Text expansions with Espanso

I've used [Alfred](https://www.alfredapp.com/) for expanding text snippets, but as I refreshed my memory of all the things [Hammerspoon](https://www.hammerspoon.org/) can do, I became curious if it could also do text expansion.
Someone has made [an attempt](https://gist.github.com/maxandersen/d09ebef333b0c7b7f947420e2a7bbbf5#file-init-lua), though there seems to be a bug in Hammerspoon preventing it from being fully reliable.
The comments, however, mentioned [Espanso](https://espanso.org/) as an alternative, which I'd never heard of.

Trying it out today, I like Espanso for several reasons:
- Configuration via YAML files — makes text expansions easy to version in Git, search, replace text in bulk, create with [UltiSnips](https://github.com/SirVer/ultisnips), and copy and paste to other applications
- Speed — so far it's notably faster than Alfred's text expansion
- Logs — `espanso log` shows errors, which I always had trouble seeing when an Alfred workflow wasn't working
- Forms — while not a glossy UI, I like how easy it is to create prompts with multiple fields
- It's open source
