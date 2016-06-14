import sbt._
import Keys._

object Dependencies {
  
  val phantomVersion = "1.26.6"
  val akkaVersion = "2.4.7"
  
  //Libraries
  val phantomDsl = "com.websudos"  %% "phantom-dsl"                                  % phantomVersion
  val akkaActor = "com.typesafe.akka" %% "akka-actor"                                % akkaVersion
  val akkaStream = "com.typesafe.akka" %% "akka-stream"                              % akkaVersion
  val akkaHttpCore = "com.typesafe.akka" %% "akka-http-core"                         % akkaVersion
  val akkaHttp = "com.typesafe.akka" %% "akka-http-experimental"                     % akkaVersion
  val akkaHttpTestkit = "com.typesafe.akka" %% "akka-http-testkit"                   % akkaVersion
  val akkaHttpSprayJson = "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion
  val scalaTest = "org.scalatest"     %% "scalatest"                                 % "2.2.5" % "test"
  val akkaTestkit = "com.typesafe.akka" %% "akka-testkit"                            % akkaVersion % "test"

  //Dependencies
  val dataAccessDependencies = Seq( phantomDsl )
  val webApiDependencies = Seq(
    akkaActor,
    akkaStream,
    akkaHttpCore,
    akkaHttp,
    akkaHttpTestkit,
    akkaHttpSprayJson,
    scalaTest,
    akkaTestkit
  )
}
