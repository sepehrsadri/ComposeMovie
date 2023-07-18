package com.sadri.composemovie.network.interceptors

import com.sadri.composemovie.network.Constants.HEADER_KEY
import com.sadri.composemovie.network.Constants.HEADER_VALUE
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


internal class HeaderInterceptor @Inject constructor() : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()

    val requestBuilder = originalRequest.newBuilder()
      .header(HEADER_KEY, HEADER_VALUE)
      .method(originalRequest.method, originalRequest.body)

    return chain.proceed(requestBuilder.build())
  }
}