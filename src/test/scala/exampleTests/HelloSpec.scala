// SPDX-License-Identifier: Apache-2.0
package exampleTests

import chisel3._
import chiseltest._

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelloSpec extends AnyFlatSpec with Matchers with ChiselScalatestTester {

  behavior of "Foo"

  it should "invert its output" in {

    test(new example.Foo) { dut =>
      val truthTable = Seq(
        0 -> 1,
        1 -> 0
      )

      truthTable.foreach {
        case (in, out) =>
          info(s"testing: $in -> $out")
          dut.a.poke(in.B)
          dut.b.expect(out.B)
      }

    }

  }

}
