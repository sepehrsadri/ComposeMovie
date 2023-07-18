package com.sadri.composemovie

import android.app.Application
import com.sadri.composemovie.logging.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : Application() {

  override fun onCreate() {
    super.onCreate()

    Logger.init()
  }

}