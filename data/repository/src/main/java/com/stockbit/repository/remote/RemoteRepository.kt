package com.stockbit.repository.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.stockbit.model.DataCrypto
import com.stockbit.remote.factory.Factory
import com.stockbit.remote.state.CryptoState
import com.stockbit.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val config: PagedList.Config,
    private val factory: Factory
) : Repository {

    var disposable: CompositeDisposable = CompositeDisposable()

    override fun getListCrypto(
        callback: MutableLiveData<CryptoState>,
        data: MutableLiveData<PagedList<DataCrypto>>
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            LivePagedListBuilder(
                factory.allCryptoDataFactory.also {
                    it.liveData = callback
                },
                config
            ).build().observeForever(data::postValue)
        }
    }

    override fun getDisposible(): CompositeDisposable = disposable

}