package com.githib.robhinds.routing

import com.githib.robhinds.domain.Colour
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

object ColourRoutes extends JsonMapping {

  val route =
    path("colour" / Segment ) { colourName: String =>
      get {
        complete {
          Colour( colourName, 0, 0, 0 )
        }
      }
    }
}