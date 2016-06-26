package com.github.robhinds.connector

import java.net.InetAddress

import com.typesafe.config.ConfigFactory
import com.websudos.phantom.connectors.{ContactPoint, ContactPoints}

import com.github.robhinds.utils.CassandraConfig

import scala.collection.JavaConversions._

object Connector extends CassandraConfig {
  val config = ConfigFactory.load()

  val inets = hosts.map(InetAddress.getByName)

  /**
    * Create a connector with the ability to connects to
    * multiple hosts in a secured cluster
    */
  lazy val connector = ContactPoints(hosts).withClusterBuilder(
    _.withCredentials( username, password )
  ).keySpace(keyspace)

  /**
    * Create an embedded connector, used for testing purposes
    */
  lazy val testConnector = ContactPoint.embedded.noHeartbeat().keySpace("my_app_test")
}