package com.sadri.composemovie.testing.data.repository

import com.sadri.composemovie.core.model.MovieDataEntity
import com.sadri.composemovie.core.model.MovieItemEntity
import com.sadri.composemovie.core.model.MoviePictureEntity
import com.sadri.composemovie.data.respository.MovieRepository

class FakeMovieRepositoryWithSuccessResult : MovieRepository {
  override suspend fun search(query: String): Result<MovieDataEntity> {
    return Result.success(
      MovieDataEntity(
        listOf(
          MovieItemEntity(
            "4601",
            title = "Enter the Dragon",
            description = "",
            picture = MoviePictureEntity("https://static.cdn.asset.filimo.com/flmt/mov_4601_1-s.jpg")
          ),
          MovieItemEntity(
            "30957",
            title = "Enter the Fat Dragon",
            description = "",
            picture = MoviePictureEntity("https://static.cdn.asset.filimo.com/flmt/mov_4601_1-s.jpg")
          ),
          MovieItemEntity(
            "24929",
            title = "Enter the Florpus",
            description = "",
            picture = MoviePictureEntity("https://static.cdn.asset.filimo.com/flmt/mov_4601_1-s.jpg")
          ),
          MovieItemEntity(
            "12171",
            title = "Enter the Fist",
            description = "",
            picture = MoviePictureEntity("https://static.cdn.asset.filimo.com/flmt/mov_4601_1-s.jpg")
          ),
        )
      )
    )
  }
}