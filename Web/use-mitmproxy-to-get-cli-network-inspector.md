# Use mitmproxy to get CLI network inspector

Anytime I have to use Chrome's network inspector in earnest, I wish for a way to navigate by keyboard rather than pointing and clicking, so after I heard about [mitmproxy](https://mitmproxy.org/), I gave it a try.

After installing with `brew install mitmproxy`, I started the proxy server by running `mitmproxy`.
I use [Brave](https://brave.com/) as a development browser, which doesn't support natively proxying, so I installed the [SwitchyOmega browser plugin](https://chromewebstore.google.com/detail/proxy-switchyomega/padekgcemlokbadohgkifijomclgjgif) and configured it to use the default proxy on localhost:8080.
After that, network requests made by the browser appeared in the terminal interface.
