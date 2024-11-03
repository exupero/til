# Find app by pattern of its window title

I started using [Portal](https://github.com/djblue/portal) recently and wanted to add a keyboard shortcut to focus its app window.
I use [Hammerspoon](https://www.hammerspoon.org/) to activate apps by their name, but the name of Portal's app is "Chrome" and I didn't want to focus an arbitrary Chrome window.
Portal's window has the title "portal - bb - 0.58.0", and Hammerspoon has a function to find an app by the title of one of its windows ([`hs.appfinder.appFromWindowTitle`](http://www.hammerspoon.org/docs/hs.appfinder.html#appFromWindowTitle)).
Rather than looking for a window on a particular version of Portal, I chose to use [`hs.appfinder.appFromWindowTitlePattern`](http://www.hammerspoon.org/docs/hs.appfinder.html#appFromWindowTitlePattern), which finds the Portal window when given only "portal".
