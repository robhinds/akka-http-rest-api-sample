name := "Sample REST API"
organization  := "com.github.robhinds"
version := "0.0.1"
scalaVersion := "2.11.8"

resolvers += "spray repo" at "http://repo.spray.io"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= {
  val akkaVersion = "2.4.7"

  Seq(
    "com.typesafe.akka" %% "akka-actor"                             % akkaVersion,
    "com.typesafe.akka" %% "akka-stream"                            % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core"                         % akkaVersion,
    "com.typesafe.akka" %% "akka-http-experimental"                 % akkaVersion,
    "com.typesafe.akka" %% "akka-http-testkit"                      % akkaVersion,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental"      % akkaVersion,
    "org.scalatest"     %% "scalatest"                              % "2.2.5" % "test",
    "com.typesafe.akka" %% "akka-testkit"                           % akkaVersion % "test"
  )
}