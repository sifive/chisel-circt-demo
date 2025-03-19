** This project is no longer relevant as upstream Chisel now supports CIRCT natively.  For instructions about how to use Chisel, please refer to the [Chisel website](https://chisel-lang.org). **

This repository demonstrates the [sifive/chisel-circt](https://github.com/sifive/chisel-circt) being used in a Chisel project.

The following requirements must be met:

- `sbt` available on your path
- [llvm/circt](https://github.com/llvm/circt) utilities (`firtool`) available on your path

With those available, you can then run one of two commands:

- `sbt run` to show a module compiled with the Scala FIRRTL Compiler (SFC) and the MLIR FIRRTL Compiler (MFC)
- `sbt test` to run simple checks that the output Verilog makes sense
