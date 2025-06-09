# `atom` can take a validator function

Besides an initial value, the `atom` function can take a function to validate new values, given as

```clojure
(atom 0 :validator (fn [x] ...))
```

`x` is the new value, and if it's not acceptable, the function should return false or throw an exception. If either happens, an `IllegalStateException` is thrown.
