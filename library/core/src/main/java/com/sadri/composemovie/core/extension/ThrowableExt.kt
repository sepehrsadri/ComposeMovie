package com.sadri.composemovie.core.extension

import android.content.Context
import com.sadri.composemovie.core.model.exception.LocalException
import com.sadri.composemovie.core.model.exception.NetworkException
import com.sadri.composemovie.core.model.exception.ServerError
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import java.net.UnknownHostException

fun Throwable.toLocalException(): LocalException {
  return LocalException(
    message = message,
    cause = cause
  )
}

fun Throwable.toNetworkException(): NetworkException {
  return when (this) {
    is NetworkException -> this
    is UnknownHostException -> NetworkException.Disconnected(cause = this)
    is IOException -> NetworkException.IO(cause = this)
    is HttpException -> this.toHttpException()
    else -> NetworkException.Unexpected
  }
}

private fun Throwable.toHttpException(): NetworkException {
  check(this is HttpException) { "$this is not a HttpException" }
  return when {
    isInternalError() -> NetworkException.Http(cause = this)
    isBadRequest() -> NetworkException.Server(cause = this, serverError = getServerError())
    isServerError() -> NetworkException.Server(cause = this, serverError = getServerError())
    else -> NetworkException.Unexpected
  }
}

private fun HttpException.getServerError(): ServerError {
  return ServerError(
    code(),
    message()
  )
}

fun LocalException.getUiMessage(context: Context): String {
  if (messageResId == null) {
    return message.orEmpty()
  }
  return context.getString(messageResId)
}

private fun HttpException.isInternalError(): Boolean {
  return code() == HTTP_INTERNAL_ERROR
}

@Suppress("MagicNumber")
private fun HttpException.isBadRequest(): Boolean {
  /* 4XX: bad request */
  return (code() / 100) == 4
}

@Suppress("MagicNumber")
private fun HttpException.isServerError(): Boolean {
  /* 5XX: server error */
  return (code() / 100) == 5
}