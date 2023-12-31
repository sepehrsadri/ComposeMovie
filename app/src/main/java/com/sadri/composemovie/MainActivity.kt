package com.sadri.composemovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sadri.composemovie.dashboard.presentation.DashboardScreen
import com.sadri.composemovie.designsystem.theme.ComposeMovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeMovieTheme {
        DashboardScreen()
      }
    }
  }
}