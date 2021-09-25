package com.stockbit.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.stockbit.model.DataCrypto
import com.stockbit.repository.remote.RemoteRepository
import com.stockbit.remote.state.CryptoState
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
) : Repository {

    override fun getListCrypto(
        callback: MutableLiveData<CryptoState>,
        data: MutableLiveData<PagedList<DataCrypto>>
    ) {
        remoteRepository.getListCrypto(callback, data)
    }

    override fun getDisposible(): CompositeDisposable {
        return remoteRepository.getDisposible()
    }

}