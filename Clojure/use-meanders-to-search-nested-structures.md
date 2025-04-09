# Use Meander's `$` to search nested structures

Recently I was trying to search a deeply nested Clojure structure, most of which I didn't care about.
While it was possible to navigate the structure with built-in Clojure functions, [zippers](https://clojuredocs.org/clojure.zip/zipper), or [Specter](https://github.com/redplanetlabs/specter), but rather than specify a path or a series of imperative steps, I wanted to match a pattern.
Fortunately, [Meander](https://github.com/noprompt/meander) has a [`$`](https://cljdoc.org/d/meander/epsilon/0.0.650/api/meander.epsilon#$) function to do just that.
Here's the invocation I used ona tree of parsed XML:

```clojure
(m/search content
 (m/$ {:tag :identifier :content (?content)})
 , ?content)
```
