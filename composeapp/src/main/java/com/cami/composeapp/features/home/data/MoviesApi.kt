package com.cami.composeapp.features.home.data

import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {

    @GET("discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=vote_average.desc&without_genres=99,10755&vote_count.gte=200")
    suspend fun getTopRatedMovies(): Response<TopRatedMoviesResponse>
}
