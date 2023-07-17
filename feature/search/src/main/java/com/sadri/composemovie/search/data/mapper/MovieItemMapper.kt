package com.sadri.composemovie.search.data.mapper

import com.sadri.composemovie.search.api.response.MovieDataResponseDto
import com.sadri.composemovie.search.data.model.MovieItemEntity
import com.sadri.composemovie.search.data.model.MoviePictureEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieItemMapper @Inject constructor() {

  fun mapToMovieItemsEntity(movieDataResponseDto: MovieDataResponseDto): List<MovieItemEntity> {
    return movieDataResponseDto.data.map { movieItemResponseDto ->
      with(movieItemResponseDto) {
        MovieItemEntity(
          id = id,
          title = title,
          picture = MoviePictureEntity(url = picture.url),
          description = description
        )
      }
    }
  }
}