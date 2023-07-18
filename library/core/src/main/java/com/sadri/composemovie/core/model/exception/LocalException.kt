package com.sadri.composemovie.core.model.exception

import androidx.annotation.StringRes

open class LocalException(
  @StringRes val messageResId: Int? = null,
  message: String? = null,
  cause: Throwable? = null
) : Throwable(message, cause)