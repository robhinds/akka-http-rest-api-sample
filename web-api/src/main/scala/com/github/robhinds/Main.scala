package com.github.robhinds

import com.github.robhinds.connector.Connector
import com.github.robhinds.database.ProductionDatabase

import routing.Routes
import utils.Config

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App with Routes with Config with ProductionDatabase with Connector.connector.Connector  {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()
  protected val log: LoggingAdapter = Logging( system, getClass )
 
  log.info( "starting Database" )
  database.autocreate().future()
  log.info( "starting server" )
  Http().bindAndHandle( logRequestResult("log",Logging.InfoLevel)( allRoutes ), httpHost, httpPort )
  log.info( "server started, awaiting requests.." )
}