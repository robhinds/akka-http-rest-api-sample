package com.github.robhinds.service

import com.github.robhinds.database.ProductionDatabase
import com.github.robhinds.domain.User
import com.websudos.phantom.dsl._

import scala.concurrent.Future

/**
 *
 * Basic @Service type component - a layer of abstraction
 * that wraps our DAO type layer.
 */
trait UserService extends ProductionDatabase {

  def getSongsByUsername(username: String): Future[List[User]] = {
    database.userModel.getByUsername(username)
  }

  def saveOrUpdate(user: User): Future[ResultSet] = {
    database.userModel.store(user)
  }
}

/**
  * Let available a singleton instance of this service class, to prevent unnecessary instances
  */
object UserService extends UserService with ProductionDatabase