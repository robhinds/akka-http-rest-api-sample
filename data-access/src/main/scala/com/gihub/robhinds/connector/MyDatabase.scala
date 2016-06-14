package com.gihub.robhinds.connector

import com.websudos.phantom.dsl._


object Defaults {
  val connector = ContactPoint.local.keySpace("my_keyspace")
}

class MyDatabase(val keyspace: KeySpaceDef) extends Database(keyspace) {
  object users extends ConcreteUsers with keyspace.Connector
}

object MyDatabase extends MyDatabase(Defaults.connector)