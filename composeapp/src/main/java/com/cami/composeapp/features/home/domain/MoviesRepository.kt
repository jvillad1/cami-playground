package com.cami.composeapp.features.home.domain

import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getTopRatedMovies(): List<Movie>

    fun observeTopRatedMovies(): Flow<List<Movie>>
}
