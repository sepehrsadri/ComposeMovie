package com.sadri.composemovie.core.model.exception

data class ServerError(
  val status: Int,
  val message: String
)