package com.github.robhinds.json

import com.github.robhinds.domain._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

trait JsonMapping extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val colourFormat = jsonFormat4( Colour )
  implicit val shapeFormat = jsonFormat2( Shape )
}