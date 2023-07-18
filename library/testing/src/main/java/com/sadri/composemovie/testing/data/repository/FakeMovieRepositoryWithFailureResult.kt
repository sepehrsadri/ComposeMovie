package com.sadri.composemovie.testing.data.repository

import com.sadri.composemovie.core.model.MovieDataEntity
import com.sadri.composemovie.core.model.exception.NetworkException
import com.sadri.composemovie.data.respository.MovieRepository

class FakeMovieRepositoryWithFailureResult : MovieRepository {
  override suspend fun search(query: String): Result<MovieDataEntity> {
    return Result.failure(
      NetworkException.Disconnected(
        Exception("no connection")
      )
    )
  }
}