# Conjure stores result of last evaluation in `c` register

Working in some Clojure code I stored a macro in the `c` register, but it kept disappearing.
Finally I used `:reg c` to check the register's contents and see what was overwriting macro, and I discovered it contained the last thing I'd evaluated in [Conjure](https://github.com/Olical/conjure).
That's a handy feature I didn't know about, though it is [covered in the "Conjure school" tutorial](https://github.com/Olical/conjure/blob/4ff479bcb79444103c1905ff4b4777960e0fc742/lua/conjure/school.lua#L79).
The feature is more fully documented [here](https://github.com/Olical/conjure/blob/4ff479bcb79444103c1905ff4b4777960e0fc742/doc/conjure.txt#L353-L363).
