package com.sadri.composemovie.search.di

import com.sadri.composemovie.search.api.SearchService
import com.sadri.composemovie.search.data.respository.SearchRepositoryImpl
import com.sadri.composemovie.search.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
internal object SearchModule {

  @Provides
  @Reusable
  fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository {
    return searchRepositoryImpl
  }

  @Provides
  @Reusable
  fun provideSearchService(retrofit: Retrofit): SearchService {
    return retrofit.create(SearchService::class.java)
  }
}