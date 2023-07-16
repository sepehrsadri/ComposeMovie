package com.sadri.composemovie.search.api.response

import com.google.gson.annotations.SerializedName

internal data class MovieDataResponseDto(
  @SerializedName("data") val data: List<MovieItemResponseDto>
)

internal data class MovieItemResponseDto(
  @SerializedName("id") val id: Long,
  @SerializedName("attributes") val attribute: MovieAttributesDto
)

internal data class MovieAttributesDto(
  @SerializedName("id") val id: Long,
  @SerializedName("movie_title") val title: String,
  @SerializedName("pic") val picture: MoviePictureDto,
  @SerializedName("descr") val description: String
)

internal data class MoviePictureDto(
  @SerializedName("movie_img_b") val url: String
)
