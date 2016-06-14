package com.github.robhinds

import routing.Routes
import utils.Config

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContext

object Main extends App with Routes with Config {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()
  protected val log: LoggingAdapter = Logging( system, getClass )
 
  log.info( "starting server" )
  Http().bindAndHandle( logRequestResult("log",Logging.InfoLevel)( allRoutes ), httpHost, httpPort )
  log.info( "server started, awaiting requests.." )
}