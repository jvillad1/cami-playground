package com.cami.composeapp.features.home.domain

interface MoviesRepository {

    suspend fun getTopRatedMovies(): List<Movie>
}
