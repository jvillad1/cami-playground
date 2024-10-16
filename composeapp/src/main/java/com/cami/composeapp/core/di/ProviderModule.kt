package com.cami.composeapp.core.di

import com.cami.composeapp.core.providers.StringProvider
import com.cami.composeapp.core.providers.StringProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProviderModule {

    @Binds
    internal abstract fun bindsStringProvider(
        stringProviderImpl: StringProviderImpl
    ): StringProvider
}
