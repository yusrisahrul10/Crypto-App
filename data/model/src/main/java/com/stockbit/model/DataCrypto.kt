package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class DataCrypto(
    @SerializedName("CoinInfo") val CoinInfo: DataCoinInfo,
    @SerializedName("DISPLAY") val DISPLAY: DataDisplay,
)
