# Query for schema

[This TIL](https://github.com/simonw/til/blob/main/graphql/get-graphql-schema.md) reported that a JSON version of a GraphQL schema is available from a GraphQL query endpoint, and while I tried `npx get-graphql-schema [graphql endpoint]` against a GraphQL endpoint running locally, I got an error about SSL and "packet length too long".
Instead, I used [this basic GraphQL query](https://stackoverflow.com/q/37397886) and [this one to get the entire schema](https://medium.com/@mrthankyou/how-to-get-a-graphql-schema-28915025de0e).
