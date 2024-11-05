# Use READMEs in dotfiles

[Yesterday I set up Espanso](https://github.com/exupero/til/blob/main/Mac/text-expansions-with-espanso.md) for text expansion.
It's configuration files were in `~/Library/Application Support/espanso`, so to version them I moved that directory to my dotfiles repo and symlinked to it from `~/Library/Application Support`.
That's different from most of my dotfiles, which are symlinked from either my home directory or `~/.config/`, and I worried that when it eventually comes time to set up my dotfiles on a new machine I'll have to reconstruct the steps I performed on my old machine.
To help with that, I added a README.md to my dotfile's `espanso` directory.
It documents (very briefly) what Espanso is, its website, what commands I ran to install it, and what steps I took after that, including where its config is and what to symlink in its place.
Hopefully that will ease the burden when I have to set up a new machine and only have a vague recollection of what I did the first time.
