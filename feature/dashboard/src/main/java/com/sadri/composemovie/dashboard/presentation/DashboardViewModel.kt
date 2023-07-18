package com.sadri.composemovie.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadri.composemovie.search.domain.interactor.SearchMovieUseCase
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
  private val searchMovieUseCase: SearchMovieUseCase
) : ViewModel() {

  private val _viewState = MutableStateFlow(DashboardViewState())
  val viewState: StateFlow<DashboardViewState> = _viewState

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

  fun search(query: String) {
    if (query.isEmpty()) return
    viewModelScope.launch {
      _viewState.value = viewState.value.copy(
        loading = true
      )
      searchMovieUseCase(query)
        .onSuccess { response ->
          _viewState.value = viewState.value.copy(
            loading = false,
            movies = response.data
          )
        }
        .onFailure {
          _viewState.value = viewState.value.copy(
            loading = false
          )
          Timber.e("fetching movies failed", it)
        }
    }
  }

  companion object {
    const val SEARCH_DEBOUNCE = 1000L
    const val DEFAULT_SEARCH_QUERY = "جدید"
  }
}