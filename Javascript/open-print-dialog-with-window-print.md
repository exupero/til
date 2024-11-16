# Open print dialog with window.print

I have a [tiny calendar app](https://apps.exupero.org/tinycal/) that can be exported as a PDF by printing the page and using the browser's print dialog to save to PDF.
But that's not apparent to users because there's no UI for that feature.
Today I learned that you can open the browser's print dialog from JavaScript with [`window.print()`](https://developer.mozilla.org/en-US/docs/Web/API/Window/print), which makes it easy to add a "Print" button.
