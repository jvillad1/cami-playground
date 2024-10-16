package com.cami.composeapp.features.home.data

import com.cami.composeapp.features.home.domain.Movie
import com.cami.composeapp.features.home.domain.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {

    override suspend fun getTopRatedMovies(): List<Movie> =
        moviesRemoteDataSource.getSuspendingTopRatedMovies().getOrThrow()

    override fun observeTopRatedMovies(): Flow<List<Movie>> =
        moviesRemoteDataSource.getTopRatedMovies()
}
