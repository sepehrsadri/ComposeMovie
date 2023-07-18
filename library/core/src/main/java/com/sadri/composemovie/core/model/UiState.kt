package com.sadri.composemovie.core.model

import com.sadri.composemovie.core.model.exception.LocalException

sealed interface UiState<out T> {
  object Loading : UiState<Nothing>
  class Success<T>(val data: T) : UiState<T>
  class Failure(val localException: LocalException) : UiState<Nothing>

  fun getErrorMessage(): String? {
    return (this as? Failure)?.localException?.message
  }

  fun getDataOrNull(): T? = (this as? Success)?.data
}

inline fun <T> UiState<T>?.doOnSuccess(func: (T) -> Unit): UiState<T>? {
  if (this is UiState.Success<T>) {
    func.invoke(data)
  }
  return this
}

inline fun UiState<*>?.doOnError(func: (LocalException) -> Unit): UiState<*>? {
  if (this is UiState.Failure) {
    func.invoke(localException)
  }
  return this
}

inline fun UiState<*>?.doOnLoading(func: () -> Unit): UiState<*>? {
  if (this is UiState.Loading) {
    func.invoke()
  }
  return this
}

val UiState<*>?.isLoading: Boolean
  get() = this is UiState.Loading

val UiState<*>?.isFailure: Boolean
  get() = this is UiState.Failure

val UiState<*>?.isSuccess: Boolean
  get() = this is UiState.Success