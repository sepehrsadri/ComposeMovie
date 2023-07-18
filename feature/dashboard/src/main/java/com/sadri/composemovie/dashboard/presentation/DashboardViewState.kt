package com.sadri.composemovie.dashboard.presentation

import com.sadri.composemovie.core.model.MovieItemEntity

data class DashboardViewState(
  val loading: Boolean = false,
  val movies: List<MovieItemEntity> = listOf()
)