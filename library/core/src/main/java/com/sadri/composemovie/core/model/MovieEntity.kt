package com.sadri.composemovie.core.model

import com.google.gson.annotations.SerializedName


data class MovieDataEntity(
  @SerializedName("data") val data: List<MovieItemEntity>
)

data class MovieItemEntity(
  @SerializedName("movie_id") val id: String,
  @SerializedName("movie_title_en") val title: String,
  @SerializedName("pic") val picture: MoviePictureEntity,
  @SerializedName("descr") val description: String
)

data class MoviePictureEntity(
  @SerializedName("movie_img_b") val url: String
)