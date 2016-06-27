package com.github.robhinds.service

import com.github.robhinds.connector.Connector
import com.github.robhinds.database.EmbeddedDatabase
import com.github.robhinds.domain.User
import com.github.robhinds.CassandraSpec
import com.datastax.driver.core.utils.UUIDs
import com.websudos.phantom.dsl.ResultSet
import com.websudos.util.testing.{Sample, _}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Based on the github sample tutorial - just amended to be the user
  * specific context. https://github.com/thiagoandrade6/cassandra-phantom
  */
class UserServiceTest extends CassandraSpec with EmbeddedDatabase with Connector.testConnector.Connector {

  /**
    * When extending your database in this case [[EmbeddedDatabase]]
    * you can access different methods related to your database such as
    * autocreate(), autodrop() and autotruncate() that create,
    * drop or truncate all your tables inside that database.
    *
    * Extending the [[Connector]] will give to you for free
    * the implicit of session and keyspace, needed for the .future()
    *
    */
  override def beforeAll(): Unit = {
    Await.result(database.autodrop().future(), 5.seconds)
    Await.result(database.autocreate().future(), 5.seconds)
  }

  implicit object UserGenerator extends Sample[User] {
    override def sample: User = {
      User(
        UUIDs.timeBased(),
        username = "user",
        password = "password"
      )
    }
  }

  
  "A User" should "be inserted into cassandra" in {
    val sample = gen[User]
    val future = this.store(sample)

    whenReady(future) { result =>
      result isExhausted() shouldBe true
      result wasApplied() shouldBe true
    }
  }
  

  it should "find a User by username" in {
    val sample = gen[User]

    val chain = for {
      store <- this.store(sample)
      get <- database.userModel.getByUsername(sample.username)
    } yield get

    whenReady(chain) { res =>
      res shouldBe defined
      this.drop(sample)
    }
  }

  
  it should "be updated into cassandra" in {
    val sample = gen[User]
    val updatedUsername = gen[String]

    val chain = for {
      store <- this.store(sample)
      unmodified <- database.userModel.getByUsername(sample.username)
      store <- this.store(sample.copy(username = updatedUsername))
      modified <- database.userModel.getByUsername(sample.username)
    } yield (unmodified, modified)

    whenReady(chain) {
      case (initial, modified) =>
        initial shouldBe defined
        initial.value.username shouldEqual sample.username

        modified shouldBe defined
        modified.value.username shouldEqual updatedUsername

        this.drop(modified.get)
    }
  }
}