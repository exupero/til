# CSS `grid-template-areas` allows drawing grid layout

Claude mocked up a small web tool for me, and perusing its code I noticed it used the CSS [`grid-template-areas`](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference/Properties/grid-template-areas).
Turns out these are options for specifying CSS grid positions.
Rather than specifying `grid-area` as top-left and bottom right cell coordinates, `grid-template-areas` allows us to draw a little picture of the grid and what cells are joined.
For example, a container element might have:

```css
grid-template-areas:
  "a a a"
  "b c c"
  "b c c";
```

and to indicate which cell a child element uses, set `grid-area`:

```css
grid-area: a;
```
