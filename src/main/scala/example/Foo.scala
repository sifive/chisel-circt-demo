// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class Foo extends MultiIOModule {
  val a = IO(Input(Bool()))
  val b = IO(Output(Bool()))

  val w = WireDefault(~a)
  dontTouch(w)

  b := w
}

object Main extends App {

  private val sfcVerilog = chisel3.stage.ChiselStage.emitSystemVerilog(new Foo)
  private val mfcVerilog = circt.stage.ChiselStage.emitSystemVerilog(new Foo)

  println(
    s"""|----------------------------------------
        |SFC Verilog:
        |----------------------------------------
        |$sfcVerilog
        |----------------------------------------
        |MFC Verilog:
        |----------------------------------------
        |$mfcVerilog
        |----------------------------------------""".stripMargin)

}
