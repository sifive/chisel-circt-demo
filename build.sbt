import Dependencies._

ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / organization     := "com.sifive"
ThisBuild / organizationName := "SiFive"

lazy val root = (project in file("."))
  .settings(
    name := "chisel-circt-demo",
    libraryDependencies ++= Seq(scalaTest % Test, chiselTest % Test),
    libraryDependencies ++= Seq(chisel, circt),
    resolvers ++= Seq(
      Resolver.sonatypeRepo("snapshots"),
      Resolver.sonatypeRepo("releases")
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
