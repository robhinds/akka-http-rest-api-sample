package com.github.robhinds.routing

import akka.http.scaladsl.server.Directives._

trait Routes extends ColourRoutes with ShapeRoutes {
  val allRoutes = 
    colourRoutes ~ 
    shapeRoutes
}