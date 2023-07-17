package com.sadri.composemovie.di

import com.sadri.composemovie.core.dispatcher.DispatcherProvider
import com.sadri.composemovie.core.dispatcher.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Provides
  @Singleton
  fun provideDispatcherProvider(): DispatcherProvider = DispatcherProviderImpl()
}