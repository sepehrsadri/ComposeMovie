package com.sadri.composemovie.search.data.model

internal data class MovieDataEntity(
  val data: List<MovieItemEntity>
)

internal data class MovieItemEntity(
  val id: Long,
  val attribute: MovieAttributesEntity
)

internal data class MovieAttributesEntity(
  val id: Long,
  val title: String,
  val picture: MoviePictureEntity,
  val description: String
)

internal data class MoviePictureEntity(
  val url: String
)