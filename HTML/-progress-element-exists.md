# &lt;progress&gt; element exists

While adding a bunch of `<input type="range" />` widgets to a simple form, I saw one that had a blue segment in the middle dancing back and forth.
I've never seen that widget before, and I wondered how I could have misconfigured a slider in a way that produced an animation.
Inspecting the element, I discovered the [`<progress>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/progress) element, useful for showing progress of something loading.
Apparently, when not given a value, a segment in the middle dances back and forth.
