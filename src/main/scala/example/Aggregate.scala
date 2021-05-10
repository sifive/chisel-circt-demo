// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class SomeBundle extends Bundle {
  val a = Input(UInt(1.W))
  val b = Output(SInt(1.W))
}

class Aggregate extends RawModule {
  val a = IO(new SomeBundle)
  val b = IO(Flipped(new SomeBundle))
  val c = IO(Input(Vec(4, Bool())))
  val d = IO(Output(Vec(4, Bool())))

  b <> a
  d <> c

}
