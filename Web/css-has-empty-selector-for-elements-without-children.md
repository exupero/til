# CSS has ':empty' selector for elements without children

A Markdown parser I was using wrapped `<div>` tags as paragraphs, e.g. `<p><div ...></p>`.
The browser parsed that forgivingly by adding some paragraph tags, but unfortunately that added some empty `<p></p>` to the DOM, which created some unwanted spacing.
As a first pass at fixing it, I thought to hide all the empty paragraph tags with `display: none`.
I wasn't sure that was possible, but it turns out CSS has an `:empty` selector to select elements without children.
Using it worked perfectly, though I ended up solving the problem closer to the source.
