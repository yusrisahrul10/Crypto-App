package com.stockbit.remote.di

import com.stockbit.remote.ApiService
import com.stockbit.remote.datasource.AllCryptoDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideAllCryptoDataSource(
        apiService: ApiService
    ) : AllCryptoDataSource = AllCryptoDataSource(apiService)
}