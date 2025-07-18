# Destructure namespaced keys with `:{namespace}/keys`

In Clojure you can destructure keys from a map using the syntax `{:keys [some-key some-other-key]}`.
When the keys have a namespace, you can provide a namespace on the symbols for the keys (e.g. `{:keys [some-namespace/some-key]}`), but since symbols for local vars can't have namespaces, you refer to it as `some-key`.
What I didn't know until I was playing around with [Nexus](https://github.com/cjohansen/nexus) is that [you can also use](https://clojure.org/guides/destructuring#_namespaced_keywords) the syntax `{:some-namespace/keys [some-key]}`.
