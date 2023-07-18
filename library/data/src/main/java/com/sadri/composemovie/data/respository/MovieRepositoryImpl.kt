package com.sadri.composemovie.data.respository

import com.sadri.composemovie.core.dispatcher.DispatcherProvider
import com.sadri.composemovie.core.model.MovieDataEntity
import com.sadri.composemovie.data.datasource.MovieDataSource
import com.sadri.composemovie.network.utils.safeApiCall
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
  private val dispatcherProvider: DispatcherProvider,
  private val searchDataSource: MovieDataSource
) : MovieRepository {
  override suspend fun search(query: String): Result<MovieDataEntity> = withContext(
    dispatcherProvider.io
  ) {
    safeApiCall {
      searchDataSource.search(query)
    }
  }
}