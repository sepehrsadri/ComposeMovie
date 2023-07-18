package com.sadri.composemovie.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadri.composemovie.core.extension.toLocalException
import com.sadri.composemovie.core.model.UiState
import com.sadri.composemovie.domain.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class DashboardViewModel @Inject constructor(
  private val movieUseCase: MovieUseCase
) : ViewModel() {

  private val _viewState: MutableStateFlow<UiState<DashboardViewState>> =
    MutableStateFlow(UiState.Loading)
  val viewState: StateFlow<UiState<DashboardViewState>> = _viewState

  private val _textSearch = MutableStateFlow("")
  private val textSearch: StateFlow<String> = _textSearch.asStateFlow()

  init {
    search(DEFAULT_SEARCH_QUERY)
    viewModelScope.launch {
      textSearch.debounce(SEARCH_DEBOUNCE).collect { query ->
        search(query)
      }
    }
  }

  fun setSearchText(it: String) {
    _textSearch.value = it
  }

  fun onRetry() {
    val query = textSearch.value.ifBlank { DEFAULT_SEARCH_QUERY }
    search(query)
  }

  fun search(query: String) {
    if (query.isEmpty()) return
    viewModelScope.launch {
      _viewState.value = UiState.Loading
      movieUseCase(query)
        .onSuccess { response ->
          _viewState.value = UiState.Success(
            DashboardViewState(response.data)
          )
        }
        .onFailure { exception ->
          _viewState.value = UiState.Failure(exception.toLocalException())
          Timber.e("fetching movies failed", exception)
        }
    }
  }

  companion object {
    const val SEARCH_DEBOUNCE = 1000L
    const val DEFAULT_SEARCH_QUERY = "actor"
  }
}