# after/ directories have to be included on runtimepath

After splitting part of my Vim config into a [public repo](https://github.com/exupero/vim), I had to update my runtime path to include the new directory.
But scripts under `after/` still weren't being included, and it appears that `after/` directories have to be added to `runtimepath` explicitly; they won't be found under directories already listed on `runtimepath`.
