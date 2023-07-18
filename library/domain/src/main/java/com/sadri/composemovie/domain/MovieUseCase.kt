package com.sadri.composemovie.domain

import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(
  private val searchRepository: com.sadri.composemovie.data.respository.MovieRepository
) {
  suspend operator fun invoke(query: String) = searchRepository.search(query)
}