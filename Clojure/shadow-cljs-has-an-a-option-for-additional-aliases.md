# shadow-cljs has an -A option for additional aliases

As I split a library out of a [shadow-cljs](https://github.com/thheller/shadow-cljs) project, I wanted to specify a Git dependency in deps.edn but also use a local version of the library while working on the project.
The solution is to add an alias that uses `:override-deps`:

```edn
:aliases {:local {:override-deps {org.exupero/svg {:local/root "../svg"}}}}}
```

I spent some time trying to figure out how get the shadow-cljs command to use that alias.
One way is to [use the `clj` command directly](https://shadow-cljs.github.io/docs/UsersGuide.html#_option_running_via_clj_directly), as in `clj -M:shadow-cljs:local -m shadow.cljs.devtools.cli watch app`, but that bypasses [server mode](https://shadow-cljs.github.io/docs/UsersGuide.html#_server_mode) and made running the tests slower.
I also tried updating `shadow-cljs.edn` to use `:deps {:aliases [:local]}`, but that makes shadow-cljs alawys use the alias, so anyone else who checked out the project would also need a copy of the external library checked out at the expected location.

By happenstance I got an error that caused shadow-cljs to print out its command line usage, which included the `-A` option:

```
  -A, --aliases ALIASES    adds aliases for use with clj, only effective when using deps.edn
```

Invoking shadow-cljs as `npx shadow-cljs server -A local` did what I wanted.

Note that server mode needs to have the `-A` option, not the commands that connect to it.
