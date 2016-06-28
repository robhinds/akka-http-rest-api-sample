package com.github.robhinds.json

import com.github.robhinds.domain.{Colour,Shape, User}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._
import java.util.UUID

trait JsonMapping extends SprayJsonSupport with DefaultJsonProtocol {
  implicit object UuidJsonFormat extends RootJsonFormat[UUID] {
    def write(x: UUID) = JsString(x.toString)
    def read(value: JsValue) = value match {
      case JsString(x) => UUID.fromString(x)
      case x           => deserializationError("Expected UUID as JsString, but got " + x)
    }
  }
  implicit val colourFormat = jsonFormat4( Colour )
  implicit val shapeFormat = jsonFormat2( Shape )
  implicit val userFormat = jsonFormat3( User )
}