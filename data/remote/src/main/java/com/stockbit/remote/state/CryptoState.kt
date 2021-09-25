package com.stockbit.remote.state

import com.stockbit.model.ResponseCrypto

sealed class CryptoState {
    object Loading : CryptoState()
    data class Result(val data: ResponseCrypto) : CryptoState()
    data class Error(val error: Throwable) : CryptoState()
}
