package com.github.robhinds.routing

import com.github.robhinds.domain.{Colour,User}
import com.github.robhinds.json.JsonMapping
import com.github.robhinds.service.UserService

import akka.http.scaladsl.server.Directives._

import com.datastax.driver.core.utils.UUIDs

trait UserRoutes extends JsonMapping {

  val userRoutes =
    path("user" / Segment ) { userName: String =>
      get {
        complete {
          UserService.getUserByUsername( userName )
        }
      }
    } ~
    path("user"){
      post {
        entity(as[String]) { body =>
          complete{
            val user: User = User(
                UUIDs.timeBased(),
                username = body,
                password = "password"
              )
            UserService.saveOrUpdate( user )
            user
          }
        }
      }
    }
}