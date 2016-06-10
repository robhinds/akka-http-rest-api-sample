package com.githib.robhinds

import routing.Routes
import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContext

object Main extends App with Routes {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()
  protected val log: LoggingAdapter = Logging( system, getClass )
 
  log.info( "starting server" )
  Http().bindAndHandle( logRequestResult("log",Logging.InfoLevel)( allRoutes ), "localhost", 8080 )
  log.info( "server started, awaiting requests.." )
}