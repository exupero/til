# Get current application's name in JXA

I had a couple AppleScript scripts that toggled Zoom's audio or video from another application then switched back to the original application.
They looked like this:

```applescript
set frontmostApp to (path to frontmost application) as text
tell application "zoom.us" to activate
tell application "System Events"
  keystroke "v" using {command down, shift down}
end tell
activate application frontmostApp
```

I asked ChatGPT to translate that to JavaScript, and to get the name of the current application it gave me the expression `Application.currentApplication().name()`, which came back `undefined`.
[This thread](https://forum.keyboardmaestro.com/t/jxa-problem-name-of-application/5685/17) indicates that while `Application(someName).name()` works, `Application.currentApplication().name()` doesn't, and instead proposed using this code:

```javascript
var app = Application.currentApplication();
app.includeStandardAdditions = true;
var propApp = app.properties();
var nameApp = propApp["name"];
```

For me, that worked in the Script Editor, but running it from the command line produced the error "Message not understood. (-1708)".
Asking ChatGPT for an alternative, it gave me this, which did work:

```javascript
Application('System Events').processes.whose({frontmost: true})[0].name();
```

The [final script](https://github.com/exupero/scripts/blob/main/zoom-toggle), written in [obb](https://github.com/babashka/obb), looks like this:

```clojure
(let [[ks] *command-line-args*
      system-events (js/Application "System Events")
      ; Can't get the app name from result of Application.currentApplication(), so we use this instead
      frontmost-app (-> system-events .-processes
                        (.whose #js {:frontmost true})
                        (aget 0)
                        .name)]
  (.activate (js/Application "zoom.us"))
  (doseq [k ks]
    (.keystroke system-events k #js {:using #js ["command down" "shift down"]}))
  (.activate (js/Application frontmost-app)))
```
