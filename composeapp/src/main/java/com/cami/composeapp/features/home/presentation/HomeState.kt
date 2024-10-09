package com.cami.composeapp.features.home.presentation

import com.cami.composeapp.features.home.domain.Movie

data class HomeState(
    val movies: List<Movie> = emptyList()
)
