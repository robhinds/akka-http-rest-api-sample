package com.gihub.robhinds.domain

import com.websudos.phantom.dsl._

case class User(
  id: UUID,
  email: String,
  name: String,
  registrationDate: DateTime
) 