package com.sadri.composemovie.search.data.respository

import com.sadri.composemovie.core.DispatcherProvider
import com.sadri.composemovie.network.utils.safeApiCall
import com.sadri.composemovie.search.data.datasource.SearchDataSource
import com.sadri.composemovie.search.api.response.MovieDataResponseDto
import com.sadri.composemovie.search.domain.repository.SearchRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SearchRepositoryImpl @Inject constructor(
  private val dispatcherProvider: DispatcherProvider,
  private val searchDataSource: SearchDataSource
) : SearchRepository {
  override suspend fun search(query: String): Result<MovieDataResponseDto> = withContext(
    dispatcherProvider.io
  ) {
    safeApiCall {
      searchDataSource.search(query)
    }
  }
}