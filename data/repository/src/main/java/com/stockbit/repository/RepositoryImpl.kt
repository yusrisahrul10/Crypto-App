package com.stockbit.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.stockbit.local.entity.CryptoEntity
import com.stockbit.model.DataCrypto
import com.stockbit.repository.remote.RemoteRepository
import com.stockbit.remote.state.CryptoState
import com.stockbit.repository.local.LocalRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : Repository {

    override fun getListCrypto(
        callback: MutableLiveData<CryptoState>,
        data: MutableLiveData<PagedList<DataCrypto>>
    ) {
        remoteRepository.getListCrypto(callback, data)
    }

    override fun getCrypto(data: MutableLiveData<PagedList<CryptoEntity>>) {
        localRepository.getCrypto(data)
    }

    override fun insertCrypto(data: List<CryptoEntity>) {
        localRepository.insertCrypto(data)
    }

    override fun getDisposible(): CompositeDisposable {
        return remoteRepository.getDisposible()
    }

}