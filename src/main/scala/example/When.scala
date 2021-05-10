// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class When extends RawModule {
  val a = IO(Input(Bool()))
  val sel = IO(Input(Bool()))
  val b = IO(Output(Bool()))

  b := DontCare
  when (sel) {
    b := 1.U
  }

}
