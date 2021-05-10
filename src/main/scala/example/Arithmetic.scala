// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class Arithmetic extends RawModule {
  val a = IO(Input(UInt(8.W)))
  val b = IO(Input(UInt(8.W)))

  Seq[(String, (UInt, UInt) => UInt)](
    ("add", _ +% _),
    ("sub", _ -% _),
    ("mul", _ * _),
  ).foreach {
    case (name, op) => IO(Output(UInt())).suggestName(name) := op(a, b)
  }

}
