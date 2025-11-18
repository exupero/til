# UltiSnips supports regex replacement on placeholders

For a new [UltiSnips](https://github.com/SirVer/ultisnips) snippet I wanted to highlight some text, get a value from it, and replace the whole selection.
I've used the `${VISUAL}` placeholder to wrap the selected text, but I'd never tried changing what was selected.
Turns out UltiSnips [supports regex replacement](https://github.com/SirVer/ultisnips/blob/master/doc/UltiSnips.txt#L836) with the syntax `${VISUAL:default/search/replace/option}`, which worked perfectly for my use case.
