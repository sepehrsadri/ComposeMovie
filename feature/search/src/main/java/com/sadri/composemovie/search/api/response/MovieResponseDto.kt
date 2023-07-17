package com.sadri.composemovie.search.api.response

import com.google.gson.annotations.SerializedName

data class MovieDataResponseDto(
  @SerializedName("data") val data: List<MovieItemResponseDto>
)

data class MovieItemResponseDto(
  @SerializedName("movie_id") val id: String,
  @SerializedName("movie_title") val title: String,
  @SerializedName("pic") val picture: MoviePictureDto,
  @SerializedName("descr") val description: String
)

data class MoviePictureDto(
  @SerializedName("movie_img_b") val url: String
)
