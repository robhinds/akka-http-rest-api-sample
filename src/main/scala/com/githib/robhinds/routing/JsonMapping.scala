package com.githib.robhinds.routing

import com.githib.robhinds.domain._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

trait JsonMapping extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val itemFormat = jsonFormat4( Colour )
}