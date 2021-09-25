package com.stockbit.remote.factory.crypto

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.stockbit.model.DataCrypto
import com.stockbit.remote.datasource.AllCryptoDataSource
import com.stockbit.remote.state.CryptoState
import javax.inject.Inject

class AllCryptoDataFactory @Inject constructor(
    private val allCryptoDataSource: AllCryptoDataSource
) : DataSource.Factory<Int, DataCrypto>() {

    lateinit var liveData: MutableLiveData<CryptoState>

    override fun create(): DataSource<Int, DataCrypto> {
        return allCryptoDataSource.also {
            it.liveData = liveData
        }
    }

}