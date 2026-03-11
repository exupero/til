# Graphviz nodes can link to URLs

I have a script that generates a Graphviz graph of the relationships between tickets in a Jira epic.
Each node includes the ticket number, and I have workflow shortcuts to open tickets easily, but it occurred to me today that it might be possible to make the nodes clickable.
I was already styling nodes with HTML labels, so I naively added an `<a>` tag, but Graphviz threw an error.
Claude pointed me to the [`URL` attribute](https://graphviz.org/docs/attrs/URL/), or its synonym `href`.
Adding that to the nodes made them clickable.

Nodes are only clickable in PDFs and SVGs, not in images, understandably.
One annoying aspect is that clicking a node in Mac Preview always triggers a popup to warn the URL will be opened in my browser, but I can live with it.
If that bothers you, generate an SVG instead and open in your browser.
Then you can use the [`target` attribute](https://graphviz.org/docs/attrs/target/) to dictate behavior.
