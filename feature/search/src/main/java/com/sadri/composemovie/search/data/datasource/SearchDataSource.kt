package com.sadri.composemovie.search.data.datasource

import com.sadri.composemovie.core.model.MovieDataEntity
import com.sadri.composemovie.search.api.SearchService
import javax.inject.Inject

class SearchDataSource @Inject constructor(
  private val service: SearchService
) {
  suspend fun search(query: String): MovieDataEntity {
    return service.search(query)
  }
}