<!-- DO NOT EDIT — THIS FILE WAS GENERATED -->

YAMLScript
==========

Add Logic to Your YAML Files


## Synopsis

Load `file.yaml` with YAMLScript:
```yaml
!yamlscript/v0/

=>:
  names =: curl(
    "https://raw.githubusercontent.com/dominictarr/" +
    "random-name/master/first-names.json")
    .json/load()

name:: names.rand-nth()
aka:: names.rand-nth()
age:: 6 * 7
color: yellow
```

and get:
```json
{
  "name": "Anthea",
  "aka": "Patrizia",
  "age": 42,
  "color": "yellow"
}
```


## Description

[YAMLScript](https://yamlscript.org) is a functional programming language with a
clean YAML syntax.

YAMLScript can be used for enhancing ordinary [YAML](https://yaml.org) files
with functional operations, such as:

* Import parts of other YAML files to any node
* String interpolation including function calls
* Data transforms including ones defined by you

This YAMLScript library should be a drop-in replacement for your current YAML
loader!

Most existing YAML files are already valid YAMLScript files.
This means that YAMLScript works as a normal YAML loader, but can also evaluate
functional expressions if asked to.

Under the hood, YAMLScript code compiles to the Clojure programming language.
This makes YAMLScript a complete functional programming language right out of
the box.

Even though YAMLScript compiles to Clojure, and Clojure compiles to Java, there
is no dependency on Java or the JVM.
YAMLScript is compiled to a native shared library (`libyamlscript.so`) that can
be used by any programming language that can load shared libraries.

To see the Clojure code that YAMLScript compiles to, you can use the YAMLScript
CLI binary, `ys`, to run:

```text
$ ys --compile file.ys
(def names
  (_-> (curl (+_ "https://raw.githubusercontent.com/dominictarr/"
                 "random-name/master/first-names.json"))
       (list json/load)))
{"age" (*_ 6 7),
 "aka" (_-> names (list rand-nth)),
 "color" "yellow",
 "name" (_-> names (list rand-nth))}
```


## Go Usage

In `go.mod`:

```go
require github.com/yaml/yamlscript-go v0.1.65
```

File `prog.go`:

```go
package main
package main

import (
        "fmt"
        "github.com/yaml/yamlscript-go"
)

func main() {
        data, err := yamlscript.Load("a: [b, c]")
        if err != nil {
                return
        }
        fmt.Println(data)
}
```



## Installation

You can install this module like any other Go module:

```bash
$ go get github.com/yaml/yamlscript-go@v0.1.65
```

but you will need to have a system install of `libyamlscript.so`.

One simple way to do that is with:

```bash
$ curl https://yamlscript.org/install | bash
```

> Note: The above command will install the latest version of the YAMLScript
command line utility, `ys`, and the shared library, `libyamlscript.so`, into
`~/local/bin` and `~/.local/lib` respectively.

See https://github.com/yaml/yamlscript?#installing-yamlscript for more info.


### Environment Variables

At the current time, you will need to set 3 environment variables to use the
module:

```bash
export CGO_CFLAGS="-I $HOME/.local/include"
export CGO_LDFLAGS="-L $HOME/.local/lib"
export LD_LIBRARY_PATH="$HOME/.local/lib"
```


## Go User Feedback

This is a very early version of yamlscript-go.
Your feedback is very welcome.
Please open an issue on this repository or chat with us directly at
<https://matrix.to/#/#chat-yamlscript:yaml.io>.


## See Also

* [YAMLScript Web Site](https://yamlscript.org)
* [YAMLScript Blog](https://yamlscript.org/blog)
* [YAMLScript Source Code](https://github.com/yaml/yamlscript)
* [YAMLScript Samples](https://github.com/yaml/yamlscript/tree/main/sample)
* [YAMLScript Programs](https://rosettacode.org/wiki/Category:YAMLScript)
* [YAML](https://yaml.org)
* [Clojure](https://clojure.org)


## Authors


* [Ingy döt Net](https://github.com/ingydotnet)
* [Andrew Pam](https://github.com/xanni)


## License & Copyright

Copyright 2022-2024 Ingy döt Net <ingy@ingy.net>

This project is licensed under the terms of the `MIT` license.
See [LICENSE](https://github.com/yaml/yamlscript/blob/main/License) for
more details.