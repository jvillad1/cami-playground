package com.cami.composeapp.features.home.domain

import androidx.annotation.CheckResult
import com.cami.composeapp.core.extensions.resultOf
import javax.inject.Inject

class GetTopRatedMovies @Inject constructor(
    private val moviesRepository: MoviesRepository
) {

    @CheckResult
    suspend operator fun invoke(): Result<List<Movie>> = resultOf {
        moviesRepository.getTopRatedMovies()
    }
}
