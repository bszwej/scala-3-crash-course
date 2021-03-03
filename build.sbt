val scala3Version = "3.0.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-workshop",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )

  scalacOptions ++= Seq(
  "-encoding", "utf8", // Option and arguments on same line
  "-Xfatal-warnings",  // New lines for each options
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  //  "-Xprint:typer"
  //  "-Xprint:parser"
  )
