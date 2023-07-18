package com.sadri.composemovie.network.utils

import com.sadri.composemovie.core.extension.toNetworkException

suspend inline fun <T> safeApiCall(
  crossinline call: suspend () -> T
): Result<T> = runCatching {
  Result.success(call())
}.getOrElse { exception ->
  Result.failure(exception.toNetworkException())
}