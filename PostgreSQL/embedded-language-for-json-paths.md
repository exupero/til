# Embedded language for JSON paths

PostgreSQL has an [embedded language for working with JSON data](https://www.postgresql.org/docs/17/functions-json.html#FUNCTIONS-SQLJSON-PATH), which makes it much easier to query a JSONB column that contains nested structures.
An example from the docs: `select jsonb_path_query(:'json', '$.track.segments[0].location');`.

In addition to drilling into structures, the language supports a `?` operator that allows specifying a condition that must match.
Another example from the docs: `select jsonb_path_query(:'json', '$.track.segments[*].HR ? (@ > 130)')`.
