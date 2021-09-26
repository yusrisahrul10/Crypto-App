package com.stockbit.repository

import androidx.lifecycle.MutableLiveData
import com.stockbit.remote.state.CryptoState
import kotlinx.coroutines.flow.Flow

abstract class NetworkBoundResource<ResultType, RequestType> {
//    protected open fun onFetchFailed() {}
//
//    protected abstract fun loadFromDB(): MutableLiveData<ResultType>
//
//    protected abstract fun shouldFetch(data: ResultType?): Boolean
//
//    protected abstract suspend fun createCall(): MutableLiveData<CryptoState<RequestType>>
//
//    protected abstract suspend fun saveCallResult(data: RequestType)
}