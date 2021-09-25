package com.stockbit.repository.di

import androidx.paging.PagedList
import com.stockbit.remote.factory.Factory
import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.ExampleRepository
import com.stockbit.repository.ExampleRepositoryImpl
import com.stockbit.repository.RepositoryImpl
import com.stockbit.repository.remote.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

//val repositoryModule = module {
//    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
//    factory { ExampleRepositoryImpl(get(), get()) as ExampleRepository }
//}

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRemoteRepository(
        config: PagedList.Config,
        factory: Factory
    ) : RemoteRepository =
        RemoteRepository(
            config, factory
        )

    @Provides
    @ViewModelScoped
    fun provideDataRepository(
        remoteRepository: RemoteRepository
    ) : RepositoryImpl = RepositoryImpl(
        remoteRepository
    )
}
