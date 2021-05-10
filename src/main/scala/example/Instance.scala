// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

trait Passthrough { this: RawModule =>
  val a = IO(Input(Bool()))
  val b = IO(Output(Bool()))
}

class Submodule extends RawModule with Passthrough {
  b := a
}

class Instance extends RawModule with Passthrough {
  val sub = Module(new Submodule)
  sub.a := a
  b := sub.b
}
