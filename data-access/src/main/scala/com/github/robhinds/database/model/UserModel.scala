package com.github.robhinds.database.model

import java.util.UUID
import com.github.robhinds.domain.User

import com.websudos.phantom.dsl._

import scala.concurrent.Future

/**
  * This abstract class is basically the DAO for the core UserTable entity, defines simple
  * queries.  These low level DAO type objects can be used in the Service layer for the basic
  * interactions with the DB
  */
abstract class UserModel extends UserTable with RootConnector {
  
  def getByUsername(username: String): Future[Option[User]] = {
    select
      .where(_.username eqs username)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .one()
  }

  def store(user: User): Future[ResultSet] = {
    insert
      .value(_.id, user.id)
      .value(_.username, user.username)
      .value(_.password, user.password)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .future()
  }
  
  def deleteByUsername(username: String): Future[ResultSet] = {
    delete
      .where(_.username eqs username)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .future()
  }
}