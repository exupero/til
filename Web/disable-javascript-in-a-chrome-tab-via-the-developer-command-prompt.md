# Disable JavaScript in a Chrome tab via the developer command prompt

I wanted to check how a web component rendered without JavaScript, and a comment on [this Reddit post](https://www.reddit.com/r/brave_browser/comments/lxnid8/any_way_to_disable_javascript/) showed how to disable JavaScript for a tab in Chrome.
Namely, open the web inspector, switch to "Sources", press (on Mac) Cmd+Shift+P, type "disable javascript", and press Enter.
A yellow warning triangle will appear next to "Sources" to indicate JavaScript is disabled.
Other tabs seem to be unaffected by this change.

To reenable JavaScript, press Cmd+Shift+P again, type "enable javascript", and press Enter.
