# Re-frame has a subscription shorthand for accessing a DB field

I re-joined the Clojurians Slack after a many-year absence, and in the `#re-frame` channel I saw someone use a shorthand syntax for `reg-sub` that I didn't know.
Instead of `(rf/reg-sub ::query-id (fn [db _] (db :field)))`, [you can use](https://day8.github.io/re-frame/api-re-frame.core/#reg-sub) `(rf/reg-sub ::query :-> :field)`.

That exists because it's tempting to do `(rf/reg-sub ::query :field)`, but I've learned first-hand that doing so uses the query vector as the default return value, i.e. it's equivalent to using `(db :field [::query ...])`.

The `:->` syntactic sugar accepts any single-argument function, not just keywords.
