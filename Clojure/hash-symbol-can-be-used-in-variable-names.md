# Hash symbol can be used in variable names

I've only used the `#` symbol in Clojure in the usual ways, for defining sets (`#{}`), regular expressions (`#"..."`), anonymous functions (`#(...)`), and tagged literals (`#uuid "..."`), but today I learned you can also include hash signs within symbol names.
It can't be the first character in the name, otherwise the Clojure reader interprets the characters that follow as naming a data reader tag, but something like this works like any other variable name:

```clojure
(defn json#>> [column field]
  ...)
```

Years ago I learned that the same is true of the quote symbol, `'`.
Though usually used as a short form of `(quote ...)`, it can also be used after the first character.
When I use it that way, it usually denotes "prime", as in `x'` ("x prime").
