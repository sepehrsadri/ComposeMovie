package com.sadri.composemovie.network.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.sadri.composemovie.network.Constants.API_BASE_URL
import com.sadri.composemovie.network.di.qualifire.LoggingInterceptor
import com.sadri.composemovie.network.di.qualifire.OkHttpChuckerInterceptor
import com.sadri.composemovie.network.interceptors.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

  private const val TIME_OUT = 30L

  @Provides
  @LoggingInterceptor
  fun provideHttpLoggingInterceptor(): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    return logging
  }

  @Provides
  @OkHttpChuckerInterceptor
  fun provideChuckerInterceptor(@ApplicationContext context: Context): Interceptor {
    return ChuckerInterceptor.Builder(context).build()
  }

  @Provides
  @Singleton
  fun provideOkHttpBuilder(
    headerInterceptor: HeaderInterceptor,
    @LoggingInterceptor loggingInterceptor: Interceptor,
    @OkHttpChuckerInterceptor chucker: Interceptor,
  ): OkHttpClient {
    return OkHttpClient.Builder()
      .readTimeout(TIME_OUT, TimeUnit.SECONDS)
      .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
      .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
      .callTimeout(TIME_OUT, TimeUnit.SECONDS)
      .addInterceptor(headerInterceptor)
      .addInterceptor(loggingInterceptor)
      .addInterceptor(chucker)
      .build()
  }


  @Provides
  fun provideConvertorFactory(): Converter.Factory {
    return GsonConverterFactory.create()
  }

  @Provides
  @Reusable
  fun provideRetrofit(
    okHttp: OkHttpClient,
    converterFactory: Converter.Factory
  ): Retrofit {
    return Retrofit.Builder()
      .baseUrl(API_BASE_URL)
      .client(okHttp)
      .addConverterFactory(converterFactory)
      .build()
  }
}