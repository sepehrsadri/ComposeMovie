package com.sadri.composemovie.search.domain.repository

import com.sadri.composemovie.search.api.response.MovieDataResponseDto

internal interface SearchRepository {
  suspend fun search(query: String): Result<MovieDataResponseDto>
}