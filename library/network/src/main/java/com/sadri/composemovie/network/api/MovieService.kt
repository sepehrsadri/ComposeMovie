package com.sadri.composemovie.network.api

import com.sadri.composemovie.core.model.MovieDataEntity
import retrofit2.http.GET
import retrofit2.http.Path

private const val QUERY_KEY = "Query"

interface MovieService {

  @GET("movie/movie/list/tagid/1000300/text/{$QUERY_KEY}/sug/on")
  suspend fun search(
    @Path(QUERY_KEY) query: String
  ): MovieDataEntity
}
