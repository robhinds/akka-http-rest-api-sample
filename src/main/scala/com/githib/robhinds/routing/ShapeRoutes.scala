package com.githib.robhinds.routing

import com.githib.robhinds.domain.Shape
import akka.http.scaladsl.server.Directives._
import com.githib.robhinds.json.JsonMapping

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