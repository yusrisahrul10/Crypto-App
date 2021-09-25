package com.stockbit.repository.di

import com.stockbit.repository.Repository
import com.stockbit.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    abstract fun bindRepository(
        repositoryImpl: RepositoryImpl
    ) : Repository
}