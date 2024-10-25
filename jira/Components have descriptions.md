# Components have descriptions

A Jira component can have a description that elaborates what it represents.
I don't know where the UI is for browsing component descriptions, so I pulled them from the API endpoint `/rest/api/3/project/{project}/component` and built a Markdown table:

```clojure
(transduce
  (comp
    (map (fn [{:keys [name description]}]
           (str "| " name " | " description " |")))
    (interpose "\n"))
  str
  "| Component | Description |\n| --- | --- |\n"
  components)
```

Edit: The UI for components is at `/jira/software/c/projects/{project}/components`.
