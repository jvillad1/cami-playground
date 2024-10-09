package com.cami.composeapp.features.home.data

import com.cami.composeapp.core.extensions.recoverResult
import com.cami.composeapp.core.extensions.resultOf
import com.cami.composeapp.features.home.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val moviesApi: MoviesApi
) {

    suspend fun getTopRatedMovies(): Result<List<Movie>> = resultOf {
        val response: Response<TopRatedMoviesResponse> =
            withContext(Dispatchers.IO) {
                moviesApi.getTopRatedMovies()
            }

        val body = response.body()

        if (response.isSuccessful && body != null) {
            body.mapToDomain()
        } else {
            error("The retrieved response is not successful or the body is empty")
        }
    }.recoverResult { throwable ->
        Timber.d(throwable.localizedMessage)
        emptyList()
    }
}
