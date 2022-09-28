// SPDX-License-Identifier: Apache-2.0
package exampleTests

import chisel3._

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FooSpec extends AnyFlatSpec with Matchers {

  behavior of "Foo"

  it should "Produce Verilog" in {

    val verilog: String = circt.stage.ChiselStage.emitSystemVerilog(new example.Foo)

    info("output looks like Verilog")
    verilog should include ("module Foo")

    info("output contains \"wire w\" which was marked as \"dontTouch\"")
    verilog should include ("wire w")

  }

}
