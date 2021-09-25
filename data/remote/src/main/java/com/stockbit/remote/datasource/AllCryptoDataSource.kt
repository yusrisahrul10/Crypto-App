package com.stockbit.remote.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.stockbit.model.DataCrypto
import com.stockbit.remote.ApiService
import com.stockbit.remote.state.CryptoState
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AllCryptoDataSource @Inject constructor(
    private val apiService: ApiService
) : PageKeyedDataSource<Int, DataCrypto>() {

    lateinit var liveData: MutableLiveData<CryptoState>

    private val disposable by lazy {
        CompositeDisposable()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DataCrypto>
    ) {
        apiService.getListCrypto("IDR", 1)
            .map<CryptoState> {
                callback.onResult(it.Data.toMutableList(), 1, 2)
                CryptoState.Result(it)
            }
            .onErrorReturn(CryptoState::Error)
            .toFlowable()
            .startWith(CryptoState.Loading)
            .subscribe(liveData::postValue)
            .let { return@let disposable::add }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataCrypto>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataCrypto>) {
        apiService.getListCrypto("IDR", params.key)
            .map<CryptoState> {
                callback.onResult(it.Data.toMutableList(), params.key + 1)
                CryptoState.Result(it)
            }
            .onErrorReturn(CryptoState::Error)
            .toFlowable()
            .startWith(CryptoState.Loading)
            .subscribe(liveData::postValue)
            .let { return@let disposable::add }
    }

}