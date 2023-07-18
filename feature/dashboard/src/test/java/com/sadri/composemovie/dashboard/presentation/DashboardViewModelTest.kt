package com.sadri.composemovie.dashboard.presentation

import com.sadri.composemovie.core.model.UiState
import com.sadri.composemovie.domain.MovieUseCase
import com.sadri.composemovie.testing.data.repository.FakeMovieRepositoryWithFailureResult
import com.sadri.composemovie.testing.data.repository.FakeMovieRepositoryWithSuccessResult
import com.sadri.composemovie.testing.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {
  @get:Rule
  val dispatcherRule = MainDispatcherRule()

  private val fakeMovieRepositoryWithFailureResult = FakeMovieRepositoryWithFailureResult()
  private val fakeMovieRepositoryWithSuccessResult = FakeMovieRepositoryWithSuccessResult()

  private lateinit var viewModel: DashboardViewModel

  @Before
  fun setUp() {
  }

  @After
  fun tearDown() {
  }

  @Test
  fun initiallyStateIsFailure() = runTest {
    // Given - When
    initialViewModelWithFailureState()

    // Then
    assertTrue(viewModel.viewState.value is UiState.Failure)
  }

  @Test
  fun initiallyStateIsSuccess() = runTest {
    // Given - When
    initialViewModelWithSuccessState()

    // Then
    assertTrue(viewModel.viewState.value is UiState.Success)
    assertEquals(4, (viewModel.viewState.value as UiState.Success).data.movies.size)
  }


  @Test
  fun searchStateIsFailure() = runTest {
    // Given
    initialViewModelWithFailureState()

    // When
    viewModel.search("test")

    // Then
    assertTrue(viewModel.viewState.value is UiState.Failure)
  }

  @Test
  fun searchStateIsSuccess() = runTest {
    // Given
    initialViewModelWithSuccessState()

    // When
    viewModel.search("test")

    // Then
    assertTrue(viewModel.viewState.value is UiState.Success)
  }

  @Test
  fun onRetryStateIsFailure() = runTest {
    // Given
    initialViewModelWithFailureState()

    // When
    viewModel.onRetry()

    // Then
    assertTrue(viewModel.viewState.value is UiState.Failure)
  }

  @Test
  fun onRetryStateIsSuccess() = runTest {
    // Given
    initialViewModelWithSuccessState()

    // When
    viewModel.search("test")

    // Then
    assertTrue(viewModel.viewState.value is UiState.Success)
  }

  private fun initialViewModelWithSuccessState() {
    viewModel = DashboardViewModel(
      movieUseCase = MovieUseCase(fakeMovieRepositoryWithSuccessResult)
    )
  }

  private fun initialViewModelWithFailureState() {
    viewModel = DashboardViewModel(
      movieUseCase = MovieUseCase(fakeMovieRepositoryWithFailureResult)
    )
  }
}