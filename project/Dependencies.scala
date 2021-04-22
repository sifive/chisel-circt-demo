import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.7"
  lazy val circt = "com.sifive" %% "chisel-circt" % "0.2.0"
  lazy val chisel = "edu.berkeley.cs" %% "chisel3" % "3.4.3"
  lazy val chiselTest = "edu.berkeley.cs" %% "chiseltest" % "0.3.3"
}
