package com.sadri.composemovie.search.data.datasource

import com.sadri.composemovie.search.api.SearchService
import com.sadri.composemovie.search.api.response.MovieDataResponseDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class SearchDataSource @Inject constructor(
  @Inject private val service: SearchService
) {
  suspend fun search(query: String): MovieDataResponseDto {
    return service.search(query)
  }
}