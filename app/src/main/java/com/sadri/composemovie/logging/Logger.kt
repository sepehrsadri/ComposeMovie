package com.sadri.composemovie.logging

import com.sadri.composemovie.BuildConfig
import timber.log.Timber

object Logger {
  fun init() {
    Timber.plant(
      if (BuildConfig.DEBUG) {
        Timber.DebugTree()
      } else {
        ProductionLogTree()
      }
    )
  }
}