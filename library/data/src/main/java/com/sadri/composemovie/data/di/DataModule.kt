package com.sadri.composemovie.data.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

  @Provides
  @Reusable
  fun bindSearchRepository(searchRepositoryImpl: com.sadri.composemovie.data.respository.MovieRepositoryImpl): com.sadri.composemovie.data.respository.MovieRepository {
    return searchRepositoryImpl
  }
}