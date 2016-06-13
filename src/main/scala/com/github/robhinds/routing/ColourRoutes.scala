package com.github.robhinds.routing

import com.github.robhinds.domain.Colour
import akka.http.scaladsl.server.Directives._
import com.github.robhinds.json.JsonMapping

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