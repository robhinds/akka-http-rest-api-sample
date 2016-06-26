package com.github.robhinds.utils

import com.typesafe.config.ConfigFactory

trait CassandraConfig {
  private val config = ConfigFactory.load()
  private val cassandraConfig = config.getConfig("cassandra")

  val hosts = cassandraConfig.getStringList("host")
  val keyspace = cassandraConfig.getString("keyspace")
  val username = cassandraConfig.getString("username")
  val password = cassandraConfig.getString("password")
}