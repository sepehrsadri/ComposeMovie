package com.sadri.composemovie.data.respository

import com.sadri.composemovie.core.model.MovieDataEntity

interface MovieRepository {
  suspend fun search(query: String): Result<MovieDataEntity>
}