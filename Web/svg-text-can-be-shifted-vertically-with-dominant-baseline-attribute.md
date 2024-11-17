# SVG text can be shifted vertically with "dominant-baseline" attribute

I've constructed a lot of SVGs programmatically, and usually when I add text I set a "dy" attribute to shift the text vertically, either to center it vertially or place it completely under its y-coordinate.
Typically I can hard-code the value based on the font size, but that wasn't an option on a project where the font size could vary depending on input parameters, so I needed a better way.

Fortunately, SVGs support a ["dominant-baseline"](https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute/dominant-baseline) attribute on `<text>` elements.
In my case "central" worked to center the text vertically, though there's also "middle" which was a pixel or two too high.
For text that should be under the y-coordinate, there's "hanging".
