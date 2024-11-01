# Snippets are found in directories named by g:UltiSnipsSnippetDirectories

I'm splitting my handful of [UltiSnips](https://github.com/SirVer/ultisnips) snippets into a repo I can make public, but I didn't know how to load snippets from anywhere except my `~/.config/nvim/UltiSnips` folder.
[This post](https://ejmastnak.com/tutorials/vim-latex/ultisnips/) gave me the answer: set `g:UltiSnipsSnippetDirectories` to multiple absolute paths.
For example,

```vim
let g:UltiSnipsSnippetDirectories=[$HOME.'/.config/nvim/UltiSnips', $HOME.'/code/snippets']
```

I could also set `g:UltiSnipsSnippetDirectories` to relative paths, and UltiSnips would look for directories with the given names in each location on the `runtimepath`, but threatens to slow down the editor, and for now the above is good enough for me.
