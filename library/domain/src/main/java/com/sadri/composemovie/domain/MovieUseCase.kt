package com.sadri.composemovie.domain

import com.sadri.composemovie.data.respository.MovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
  private val movieRepository: MovieRepository
) {
  suspend operator fun invoke(query: String) = movieRepository.search(query)
}