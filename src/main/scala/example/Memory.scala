// SPDX-License-Identifier: Apache-2.0
package example

import chisel3._

class ReadBundle extends Bundle {
  val addr = Input(UInt(4.W))
  val data = Output(UInt(8.W))
  val en = Input(Bool())
}

class WriteBundle extends Bundle {
  val addr = Input(UInt(4.W))
  val data = Input(UInt(8.W))
  val en = Input(Bool())
}

class Memory extends MultiIOModule {
  val read = IO(new ReadBundle)
  val write = IO(new WriteBundle)

  val mem = SyncReadMem(16, UInt(8.W))

  read.data := DontCare

  when (read.en) {
    read.data := mem(read.addr)
  }

  when (write.en) {
    mem(write.addr) := write.data
  }

}
