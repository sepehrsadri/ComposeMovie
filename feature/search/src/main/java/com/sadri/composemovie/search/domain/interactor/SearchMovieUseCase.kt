package com.sadri.composemovie.search.domain.interactor

import com.sadri.composemovie.search.domain.repository.SearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class SearchMovieUseCase @Inject constructor(
  private val searchRepository: SearchRepository
) {
  suspend operator fun invoke(query: String) = searchRepository.search(query)
}