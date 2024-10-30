# Define user command from Lua

I have several Neovim functions written in Lua (well, [Fennel](https://fennel-lang.org/), actually), and to invoke a Lua function from a Vim command I've been using this pattern:

```lua
_G.someFunction = function()
  -- ...
end
vim.command("command! -nargs=0 SomeCommand lua _G.someFunction()")
```

Today I learned about [`vim.api.nvim_create_user_command`](https://github.com/nanotee/nvim-lua-guide?tab=readme-ov-file#defining-user-commands), which allows giving a Lua function directly:

```lua
vim.api.nvim_create_user_command('SomeCommand', function(opts)
  -- ...
end, {nargs = 0})
```
