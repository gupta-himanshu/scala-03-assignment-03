name := "modular-programming-scala"

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.0" % "test" withSources(),
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
)
