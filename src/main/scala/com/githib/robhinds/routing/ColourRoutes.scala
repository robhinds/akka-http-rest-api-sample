package com.githib.robhinds.routing

import com.githib.robhinds.domain.Colour
import akka.http.scaladsl.server.Directives._
import com.githib.robhinds.json.JsonMapping

trait ColourRoutes extends JsonMapping {

  val colourRoutes =
    path("colour" / Segment ) { colourName: String =>
      get {
        complete {
          Colour( colourName, 0, 0, 0 )
        }
      }
    }
}