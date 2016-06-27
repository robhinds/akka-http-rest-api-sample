package com.github.robhinds.database

import com.github.robhinds.database.model.UserModel
import com.github.robhinds.connector.Connector._
import com.websudos.phantom.db.DatabaseImpl
import com.websudos.phantom.dsl._

/**
 * Based on https://github.com/thiagoandrade6/cassandra-phantom examples
 */
class UserDatabase(override val connector: KeySpaceDef) extends DatabaseImpl(connector) {
  object userModel extends UserModel with connector.Connector
}

/**
  * This is the production database, it connects to a secured cluster with multiple contact points
  */
object ProductionDb extends UserDatabase(connector)

trait ProductionDatabaseProvider {
  def database: UserDatabase
}

trait ProductionDatabase extends ProductionDatabaseProvider {
  override val database = ProductionDb
}

/**
  * Thanks for the Phantom plugin, you can start an embedded cassandra in memory,
  * in this case we are using it for tests
  */
object EmbeddedDb extends UserDatabase(testConnector)

trait EmbeddedDatabaseProvider {
  def database: UserDatabase
}

trait EmbeddedDatabase extends EmbeddedDatabaseProvider {
  override val database = EmbeddedDb
}