package com.sadri.composemovie.search.di

import com.sadri.composemovie.search.api.SearchService
import com.sadri.composemovie.search.data.datasource.SearchDataSource
import com.sadri.composemovie.search.data.respository.SearchRepositoryImpl
import com.sadri.composemovie.search.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object SearchModule {

  @Provides
  @Singleton
  fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository {
    return searchRepositoryImpl
  }

  @Provides
  @Singleton
  fun provideSearchDataSource(retrofit: Retrofit): SearchDataSource {
    return SearchDataSource(
      retrofit.create(SearchService::class.java)
    )
  }
}