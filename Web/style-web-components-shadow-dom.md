# Style web component's shadow DOM

I've been using web components to add interactive widgets to my [blog](https://blog.exupero.org/), most recently a simple 3D wireframe viewer.
The diagrams have a transparent background, so the black lines show fine in the browser where the page's background is light, but in my RSS reader, where the background is dark, the lines were at best very difficult to see.
To solve that, I added a white SVG rectangle to serve as a background in the unstyled RSS view, but to hide it on web, I had to style the web component's shadow DOM, where the background lives.

To do that, I [discovered](https://webcomponents.guide/learn/components/styling/) that elements in a web component's shadow DOM can be given a `part` attribute, then can be styled in CSS with the `::part(...)` selector.
In my case, I gave the SVG rectangle `part="background"` and in my CSS added `view-3d::part(background) { display: none }`, which hid the component's background when viewed in a browser.
