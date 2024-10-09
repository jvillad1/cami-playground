package com.cami.composeapp.core.di

import com.cami.composeapp.features.home.data.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object MoviesNetworkModule {

    @Provides
    internal fun providesMoviesApi(retrofit: Retrofit): MoviesApi =
        retrofit.create(MoviesApi::class.java)
}
