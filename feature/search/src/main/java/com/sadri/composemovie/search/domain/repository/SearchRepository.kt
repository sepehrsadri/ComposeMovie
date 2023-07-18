package com.sadri.composemovie.search.domain.repository

import com.sadri.composemovie.core.model.MovieDataEntity

interface SearchRepository {
  suspend fun search(query: String): Result<MovieDataEntity>
}