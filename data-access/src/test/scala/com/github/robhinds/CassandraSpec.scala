package com.github.robhinds

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

abstract class CassandraSpec extends FlatSpec
  with Matchers
  with Inspectors
  with ScalaFutures
  with OptionValues
  with BeforeAndAfterAll