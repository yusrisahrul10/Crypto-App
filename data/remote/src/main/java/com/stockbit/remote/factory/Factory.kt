package com.stockbit.remote.factory

import com.stockbit.remote.factory.crypto.AllCryptoDataFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
data class Factory @Inject constructor(
    val allCryptoDataFactory: AllCryptoDataFactory
)
