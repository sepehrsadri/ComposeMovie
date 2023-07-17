package com.sadri.composemovie.search.data.model

data class MovieItemEntity(
  val id: String,
  val title: String,
  val picture: MoviePictureEntity,
  val description: String
)

data class MoviePictureEntity(
  val url: String
)