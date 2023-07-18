package com.sadri.composemovie.core.model.exception

import androidx.annotation.StringRes
import com.sadri.composemovie.core.R

sealed class NetworkException(
  @StringRes messageResId: Int? = null,
  message: String? = null,
  cause: Throwable? = null
) : LocalException(messageResId, message, cause) {

  object Unexpected : NetworkException(
    messageResId = R.string.error_unexpected_exception,
    message = "Unexpected exception"
  )

  class IO(
    override val cause: Throwable
  ) : NetworkException(
    messageResId = R.string.error_network_io_exception,
    cause = cause
  )

  class Http(
    override val cause: Throwable
  ) : NetworkException(
    messageResId = R.string.error_internal_server_exception,
    cause = cause
  )

  class Disconnected(
    override val cause: Throwable
  ) : NetworkException(
    messageResId = R.string.error_disconnect_exception,
    cause = cause
  )

  class Server(
    override val cause: Throwable,
    val serverError: ServerError
  ) : NetworkException(
    message = serverError.message,
    cause = cause
  )
}