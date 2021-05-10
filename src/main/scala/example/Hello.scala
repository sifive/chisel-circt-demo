// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class Hello extends MultiIOModule {
  val a = IO(Input(Bool()))
  val b = IO(Output(Bool()))

  b := ~a
}
