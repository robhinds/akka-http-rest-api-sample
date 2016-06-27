package com.github.robhinds.database.model

import java.util.UUID
import com.github.robhinds.domain.User

import com.websudos.phantom.dsl._

import scala.concurrent.Future

/**
  * Create the Cassandra representation of the user table.
  * 
  * This just captures the columns and keys of the table - very basic table structure, for comparison, 
  * it is similar to a JPA entity for example.
  */
class UserTable extends CassandraTable[UserModel, User] {

  override def tableName: String = "users"

  object username extends StringColumn(this) with PartitionKey[String]
  object id extends TimeUUIDColumn(this) with ClusteringOrder[UUID] { override lazy val name = "user_id" }
  object password extends StringColumn(this)

  override def fromRow(r: Row): User = User( id(r), username(r), password(r) )
}
