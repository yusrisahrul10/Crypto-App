package com.stockbit.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.stockbit.local.entity.CryptoEntity
import com.stockbit.model.DataCrypto
import com.stockbit.remote.state.CryptoState
import io.reactivex.disposables.CompositeDisposable

interface Repository {

    fun getListCrypto(
        callback : MutableLiveData<CryptoState>,
        data: MutableLiveData<PagedList<DataCrypto>>
    )

    fun getCrypto(
            data: MutableLiveData<PagedList<CryptoEntity>>
    )

    fun insertCrypto(
            data: List<CryptoEntity>
    )

    fun getDisposible() : CompositeDisposable

}