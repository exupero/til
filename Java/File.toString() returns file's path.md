# File.toString() returns file's path

Calling `.toString()` on a `File` instance [returns the file's path](https://docs.oracle.com/javase/8/docs/api/java/io/File.html#toString--).

I'm happy to discover this because I whenever I've needed children of a folder I've tended to work with strings instead of `File` objects, turning string-based paths into `File`s late in the game.
It's much more convenient to work with `File`s directly and get the path from them when necessary.
