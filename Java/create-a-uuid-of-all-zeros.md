# Create a UUID of all zeros

I wanted a UUID that represented a missing value, and [this answer](https://stackoverflow.com/a/20840504) taught me that you can do that in Java with `new UUID(0, 0)`.
