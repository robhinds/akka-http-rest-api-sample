package com.githib.robhinds

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContext
import spray.json._


object Main extends App {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  val route =
    path("hello") {
      get {
        complete {
          "<h1>Say hello to akka-http</h1>"
        }
      }
    }
 
  println( "starting server" )
  Http().bindAndHandle(route, "localhost", 8080)
}