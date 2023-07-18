package com.sadri.composemovie.dashboard.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sadri.composemovie.core.model.UiState
import com.sadri.composemovie.core.model.isLoading
import com.sadri.composemovie.dashboard.R
import com.sadri.composemovie.designsystem.component.FailureComponent
import com.sadri.composemovie.designsystem.component.MoviesList
import com.sadri.composemovie.designsystem.theme.space
import com.sadri.composemovie.search.presentation.SearchBar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DashboardScreen(
  viewModel: DashboardViewModel = hiltViewModel()
) {
  val focusRequester = remember { FocusRequester() }
  val keyboardController = LocalSoftwareKeyboardController.current
  val state = viewModel.viewState.collectAsState().value
  Scaffold(
    topBar = {
      SearchBar(
        modifier = Modifier.focusRequester(focusRequester),
        defaultText = "",
        hint = stringResource(id = R.string.hint_search),
        onValueChanged = viewModel::setSearchText,
        onSubmitSearchClicked = viewModel::search
      )
    }
  ) { contentPadding ->
    val modifier = Modifier.padding(contentPadding)
    Box(
      modifier = modifier
        .fillMaxSize()
        .padding(MaterialTheme.space.medium)
    ) {
      when (state) {
        is UiState.Loading -> {
          Loading()
        }
        is UiState.Success -> {
          MoviesList(movies = state.data.movies)
        }
        is UiState.Failure -> {
          FailureComponent(
            error = state.localException,
            onRetryClick = viewModel::onRetry,
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colorScheme.primary
          )
        }
      }
    }
    LaunchedEffect(state.isLoading) {
      keyboardController?.hide()
    }
  }
}

@Composable
fun BoxScope.Loading() {
  CircularProgressIndicator(
    modifier = Modifier
      .size(MaterialTheme.space.xxLarge)
      .align(Alignment.Center),
    color = MaterialTheme.colorScheme.primary
  )
}
