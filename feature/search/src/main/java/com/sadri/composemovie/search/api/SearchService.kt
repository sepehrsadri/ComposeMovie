package com.sadri.composemovie.search.api

import com.sadri.composemovie.search.api.response.MovieDataResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

private const val QUERY_KEY = "Query"

internal interface SearchService {

  @GET("movie/movie/list/tagid/1000300/text/{${QUERY_KEY}}/sug/on")
  suspend fun search(
    @Path(QUERY_KEY) query: String
  ): MovieDataResponseDto
}
