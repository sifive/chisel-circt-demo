// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class Bitwise extends RawModule {
  val a = IO(Input(Bool()))
  val b = IO(Input(Bool()))

  Seq[(String, (Bool, Bool) => Bool)](
    ( "and", _ & _),
    ( "or", _ | _),
    ( "xor", _ ^ _)
  ).foreach {
    case (name, op) => IO(Output(Bool())).suggestName(name) := op(a, b)
  }

  Seq[(String, Bool => Bool)](
    ("andR", _.andR()),
    ("orR", _.orR()),
    ("xorR", _.xorR())
  ).foreach {
    case (name, op) => IO(Output(Bool())).suggestName(name) := op(a)
  }

}
