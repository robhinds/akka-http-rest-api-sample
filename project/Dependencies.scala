import sbt._
import Keys._

object Dependencies {
  
  val phantomVersion = "1.26.6"
  val akkaVersion = "2.4.7"
  
  //Libraries
  val phantomDsl = "com.websudos"  %% "phantom-dsl"                                  % phantomVersion
  val phantomStreams = "com.websudos" %%  "phantom-reactivestreams"                  % phantomVersion
  val akkaSlf4j = "com.typesafe.akka" %%  "akka-slf4j"                               % akkaVersion
  val akkaActor = "com.typesafe.akka" %% "akka-actor"                                % akkaVersion
  val akkaStream = "com.typesafe.akka" %% "akka-stream"                              % akkaVersion
  val akkaStreamTestkit = "com.typesafe.akka" %%  "akka-stream-testkit"              % akkaVersion
  val akkaHttpCore = "com.typesafe.akka" %% "akka-http-core"                         % akkaVersion
  val akkaHttp = "com.typesafe.akka" %% "akka-http-experimental"                     % akkaVersion
  val akkaHttpTestkit = "com.typesafe.akka" %% "akka-http-testkit"                   % akkaVersion
  val akkaHttpSprayJson = "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion
  val akkaTestkit = "com.typesafe.akka" %% "akka-testkit"                            % akkaVersion % "test"
  val scalaTest = "org.scalatest" %% "scalatest"                                     % "2.2.5" % "test"
  val utilTest = "com.websudos" %% "util-testing" % "0.13.0"                         % "test, provided"


  //Dependencies
  val dataAccessDependencies = Seq( 
      phantomDsl,
      scalaTest,
      akkaTestkit,
      akkaStreamTestkit,
      akkaActor,
      akkaStream,
      akkaSlf4j,
      utilTest
  )
  val webApiDependencies = Seq(
    akkaActor,
    akkaStream,
    akkaSlf4j,
    akkaHttpCore,
    akkaHttp,
    akkaHttpTestkit,
    akkaHttpSprayJson,
    scalaTest,
    akkaTestkit
  )
}
