package com.cami.composeapp.features.home.data

import com.cami.composeapp.features.home.domain.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopRatedMoviesResponse(
    val page: Int? = null,
    val results: List<MovieResponse>? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null
)

fun TopRatedMoviesResponse.mapToDomain(): List<Movie> =
    this.results?.map { it.mapToDomain() } ?: emptyList()
