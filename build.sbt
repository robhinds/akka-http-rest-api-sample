import Dependencies._

name := "sample-cassandra-akka-app"
organization := "com.github.robhinds"
version := "1.0"

lazy val root = ( project in file(".") )
  .aggregate( webApi, dataAccess )
  .settings(
    run := {
      ( run in webApi in Compile ).evaluated
    }
  )

lazy val dataAccess = (project in file("data-access"))
  .settings(commonSettings: _*)
  .settings( libraryDependencies ++= dataAccessDependencies )
  
lazy val webApi = (project in file("web-api"))
  .dependsOn(dataAccess)
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings: _*)
  .settings( libraryDependencies ++= webApiDependencies )


lazy val commonSettings = Seq(
  organization  := "com.github.robhinds",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
  scalaVersion := "2.11.8",
  resolvers ++= Seq(
    "Typesafe repository snapshots"    at "http://repo.typesafe.com/typesafe/snapshots/",
    "Typesafe repository releases"     at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype repo"                    at "https://oss.sonatype.org/content/groups/scala-tools/",
    "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
    "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
    "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
    "Java.net Maven2 Repository"       at "http://download.java.net/maven/2/",
    "Twitter Repository"               at "http://maven.twttr.com",
    "Websudos releases"                at "https://dl.bintray.com/websudos/oss-releases/",
    "spray repo"                       at "http://repo.spray.io"
  )
)