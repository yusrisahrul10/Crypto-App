package com.stockbit.hiring.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.stockbit.model.DataCrypto
import com.stockbit.remote.state.CryptoState
import com.stockbit.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val state: MutableLiveData<CryptoState> by lazy {
        MutableLiveData<CryptoState>()
    }

    val data : MutableLiveData<PagedList<DataCrypto>> by lazy {
        MutableLiveData<PagedList<DataCrypto>>()
    }

    fun getListCrypto() {
        repository.getListCrypto(state, data)
    }
}