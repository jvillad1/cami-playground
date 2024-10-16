package com.cami.composeapp.features.home.domain

import androidx.annotation.CheckResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveTopRatedMovies @Inject constructor(
    private val moviesRepository: MoviesRepository
) {

    @CheckResult
    operator fun invoke(): Flow<List<Movie>> = moviesRepository.observeTopRatedMovies()
}
