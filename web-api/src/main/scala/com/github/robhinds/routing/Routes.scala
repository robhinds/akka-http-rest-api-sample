package com.github.robhinds.routing

import akka.http.scaladsl.server.Directives._

trait Routes extends ColourRoutes with ShapeRoutes with UserRoutes {
  val allRoutes = 
    colourRoutes ~ 
    shapeRoutes ~
    userRoutes
}