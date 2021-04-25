val scala3Version = "3.0.0-RC3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-crash-course",
    version := "0.1.0",

    scalaVersion := scala3Version,
  )

  scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  // "-indent", "-rewrite"
  //  "-Xprint:typer"
  //  "-Xprint:parser"
  )
