package com.cami.composeapp.features.home.data

import com.cami.composeapp.features.home.domain.Movie
import com.cami.composeapp.features.home.domain.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {

    override suspend fun getTopRatedMovies(): List<Movie> =
        moviesRemoteDataSource.getTopRatedMovies().getOrThrow()
}
