name := "pegasus-website"
scalaVersion := "3.3.4"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "dev.zio" %% "zio-http" % "3.0.1"
)