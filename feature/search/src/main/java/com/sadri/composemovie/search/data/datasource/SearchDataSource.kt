package com.sadri.composemovie.search.data.datasource

import com.sadri.composemovie.search.api.SearchService
import com.sadri.composemovie.search.api.response.MovieDataResponseDto
import javax.inject.Inject

class SearchDataSource @Inject constructor(
  private val service: SearchService
) {
  suspend fun search(query: String): MovieDataResponseDto {
    return service.search(query)
  }
}