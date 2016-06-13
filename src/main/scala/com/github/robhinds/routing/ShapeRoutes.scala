package com.github.robhinds.routing

import com.github.robhinds.domain.Shape
import akka.http.scaladsl.server.Directives._
import com.github.robhinds.json.JsonMapping

trait ShapeRoutes extends JsonMapping {

  val shapeRoutes =
    path("shape" / Segment ) { shapeName: String =>
      get {
        complete {
          Shape( shapeName, 1 )
        }
      }
    }
}