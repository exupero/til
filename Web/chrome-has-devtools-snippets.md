# Chrome has DevTools snippets

When inspecting an element in the Chrome DevTools "Elements" pane, the selected element is stored as a JavaScript value under the name `$0`.
I experimented with accessing that value from an external script, but it's only available in the DevTools pane unless you manually attach the value to, say, the `window` object with `window.$0 = $0`.
Hoping there was a way to automate that change, I learned that Chrome allows you to [save snippets of JavaScript code and execute them](https://developer.chrome.com/docs/devtools/javascript/snippets/) by name when focus is on DevTools.

It's not a great solution for replacing something already as easy as `window.$0 = $0`, and I'm not sure how useful it will be given that I already use [TamperMonkey](https://www.tampermonkey.net/), but I'll keep it in mind.
