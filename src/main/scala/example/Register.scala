// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class Register extends MultiIOModule {
  val d = IO(Input(Bool()))
  val q = IO(Output(Bool()))
  val otherClock = IO(Input(Clock()))
  val otherReset = IO(Input(AsyncReset()))

  val r = Reg(Bool())
  val rInit = RegInit(false.B)
  val rInitOther = withClockAndReset(otherClock, otherReset) {
    RegInit(true.B)
  }

  r := d
  rInit := d
  rInitOther := d

  q := Seq(r, rInit, rInitOther).reduce(_ | _)
}
