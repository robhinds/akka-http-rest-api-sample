package com.github.robhinds.domain

import java.util.UUID

case class User (
  id: UUID,
  username: String,
  password: String
)