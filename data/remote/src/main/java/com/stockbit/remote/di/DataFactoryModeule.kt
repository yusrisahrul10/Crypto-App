package com.stockbit.remote.di

import com.stockbit.remote.datasource.AllCryptoDataSource
import com.stockbit.remote.factory.Factory
import com.stockbit.remote.factory.crypto.AllCryptoDataFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataFactoryModeule {

    @Provides
    @Singleton
    fun provideFactory(
        allCryptoDataFactory: AllCryptoDataFactory
    ) : Factory = Factory(
        allCryptoDataFactory
    )

    @Provides
    @Singleton
    fun provideAllCryptoDataFactory(
        allCryptoDataSource: AllCryptoDataSource
    ) : AllCryptoDataFactory = AllCryptoDataFactory(allCryptoDataSource)
}