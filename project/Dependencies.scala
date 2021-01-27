import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.2"
  lazy val circt = "com.sifive" %% "chisel-circt" % "0.1.0"
  lazy val chisel = "edu.berkeley.cs" %% "chisel3" % "3.4.1"
  lazy val chiselTest = "edu.berkeley.cs" %% "chiseltest" % "0.3.1"
}
