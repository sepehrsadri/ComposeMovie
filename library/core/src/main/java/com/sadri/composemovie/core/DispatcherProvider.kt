package com.sadri.composemovie.core

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
  val ui: CoroutineDispatcher
  val io: CoroutineDispatcher
  val default: CoroutineDispatcher
}