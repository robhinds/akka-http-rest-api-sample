package com.githib.robhinds


import akka.stream.ActorMaterializer
import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Directives._

object Main extends App {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected val log: LoggingAdapter = Logging(system, getClass)
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()


}