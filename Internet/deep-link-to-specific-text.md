# Deep link to specific text

Browsers (mostly) support [linking to specific text](https://alfy.blog/2024/10/19/linking-directly-to-web-page-content.html) using a text fragment in the URL.
The format is:

```
https://example.com/page.html#:~:text=[prefix-,]textStart[,textEnd][,-suffix]
```

`textStart` and `textEnd` allow specifying the range of text without, while `prefix-` and `-suffix` denote text that won't be highlighted but is used to find the right text to highlight.
Multiple highlights can be made using `&`.

In my testing, it worked in Safari 17.5 and Firefox 131.0, but not in Brave 1.70 (Chromium 129.0).
Here's the full [Can I Use](https://caniuse.com/url-scroll-to-text-fragment).
