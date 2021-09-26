package com.stockbit.repository.local

import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.stockbit.local.AppDatabase
import com.stockbit.local.entity.CryptoEntity
import com.stockbit.model.DataCrypto
import com.stockbit.remote.state.CryptoState
import com.stockbit.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LocalRepository @Inject constructor(
        private val database: AppDatabase,
        private val config: PagedList.Config
) : Repository {

    var disposable: CompositeDisposable = CompositeDisposable()

    override fun getListCrypto(
            callback: MutableLiveData<CryptoState>,
            data: MutableLiveData<PagedList<DataCrypto>>) {
        throw UnsupportedOperationException()

    }

    override fun getCrypto(data: MutableLiveData<PagedList<CryptoEntity>>) {
        LivePagedListBuilder(
                database.exampleDao().getData(),
                config
        ).build().observeForever(data::postValue)
    }

    override fun insertCrypto(data: List<CryptoEntity>) {
        database.exampleDao().insert(data)
    }

    override fun getDisposible(): CompositeDisposable = disposable
}