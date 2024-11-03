# Show code's AST

I had a script for printing the AST of some Python code:

```python
#!/usr/bin/env python

import ast
import sys

print(ast.dump(ast.parse(sys.stdin.read()), indent=2))
```

[This TIL](https://github.com/simonw/til/blob/main/python/stdlib-cli-tools.md#ast), however, shows that all you need is `python3.11 -m ast`.
