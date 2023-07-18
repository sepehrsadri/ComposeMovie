package com.sadri.composemovie.data.datasource

import com.sadri.composemovie.core.model.MovieDataEntity
import com.sadri.composemovie.network.api.MovieService
import javax.inject.Inject

class MovieDataSource @Inject constructor(
  private val service: MovieService
) {
  suspend fun search(query: String): MovieDataEntity {
    return service.search(query)
  }
}