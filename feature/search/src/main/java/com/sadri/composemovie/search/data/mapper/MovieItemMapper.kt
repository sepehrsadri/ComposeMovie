package com.sadri.composemovie.search.data.mapper

import com.sadri.composemovie.search.api.response.MovieAttributesDto
import com.sadri.composemovie.search.data.model.MovieAttributesEntity
import com.sadri.composemovie.search.data.model.MovieDataEntity
import com.sadri.composemovie.search.api.response.MovieDataResponseDto
import com.sadri.composemovie.search.data.model.MovieItemEntity
import com.sadri.composemovie.search.api.response.MovieItemResponseDto
import com.sadri.composemovie.search.api.response.MoviePictureDto
import com.sadri.composemovie.search.data.model.MoviePictureEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MovieItemMapper @Inject constructor() {

  fun mapToMovieDataEntity(movieDataResponseDto: MovieDataResponseDto): MovieDataEntity {
    return MovieDataEntity(
      data = movieDataResponseDto.data.map { mapToMovieItemEntity(it) }
    )
  }

  private fun mapToMovieItemEntity(movieItemResponseDto: MovieItemResponseDto): MovieItemEntity {
    with(movieItemResponseDto) {
      return MovieItemEntity(
        id = id,
        attribute = mapToMovieAttributesEntity(attribute)
      )
    }
  }

  private fun mapToMovieAttributesEntity(movieAttributesDto: MovieAttributesDto): MovieAttributesEntity {
    with(movieAttributesDto) {
      return MovieAttributesEntity(
        id = id,
        title = title,
        picture = mapToMoviePictureEntity(picture),
        description = description
      )
    }
  }

  private fun mapToMoviePictureEntity(moviePictureDto: MoviePictureDto): MoviePictureEntity {
    return MoviePictureEntity(url = moviePictureDto.url)
  }
}