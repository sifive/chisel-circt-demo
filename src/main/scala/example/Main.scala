// SPDX-License-Identifier: Apache-2.0
package example

import chisel3.RawModule
import chisel3.stage.ChiselGeneratorAnnotation

case class Example(f: () => RawModule, name: String)

object Main extends App {

  private def chiselArgs(targetDirectory: String) = Array(
    "-X", "verilog",
    "-E", "high",
    "-E", "middle",
    "-E", "low",
    "-E", "verilog",
    "-td", targetDirectory
  )

  private def circtArgs(targetDirectory: String) = Array(
    "-td", targetDirectory,
    "--target", "verilog"
  )

  Seq(
    Example(() => new Hello, "Hello"),
    Example(() => new Bitwise, "Bitwise"),
    Example(() => new Arithmetic, "Arithmetic"),
    Example(() => new Aggregate, "Aggregate"),
    Example(() => new Instance, "Instance"),
    Example(() => new Register, "Register"),
    Example(() => new When, "When"),
    Example(() => new Memory, "Memory")
  ).par.foreach{ a =>
    (new chisel3.stage.ChiselStage).execute(chiselArgs(s"build/SFC/${a.name}"), Seq(ChiselGeneratorAnnotation(a.f)))
    (new circt.stage.ChiselStage).execute(circtArgs(s"build/MFC/${a.name}"), Seq(ChiselGeneratorAnnotation(a.f)))
  }

}
