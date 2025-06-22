# Inputs have `.valueAsNumber` and `.valueAsDate`

Watching [7 UIs with Replicant, episode 3](https://www.youtube.com/watch?v=l_YMx8ytrBw), I learned that JavaScript inputs not only have a `.value` field, but a couple of attributes that automatically parse the input's value: [`.valueAsNumber`](https://developer.mozilla.org/en-US/docs/Web/API/HTMLInputElement/valueAsNumber), which parses `.value` as a float or integer or `NaN`, and [`.valueAsDate`](https://developer.mozilla.org/en-US/docs/Web/API/HTMLInputElement/valueAsDate), which parses it as a `Date` or `null`.
