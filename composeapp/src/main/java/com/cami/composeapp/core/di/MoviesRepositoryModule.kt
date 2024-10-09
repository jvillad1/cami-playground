package com.cami.composeapp.core.di

import com.cami.composeapp.features.home.data.MoviesRepositoryImpl
import com.cami.composeapp.features.home.domain.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MoviesRepositoryModule {

    @Binds
    abstract fun bindRepository(
        moviesRepositoryImpl: MoviesRepositoryImpl
    ): MoviesRepository
}
