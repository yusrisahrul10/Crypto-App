package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class DataIdr(
    @SerializedName("CHANGE24HOUR") val CHANGE24HOUR: String,
    @SerializedName("CHANGEPCT24HOUR") val CHANGEPCT24HOUR: String,
    @SerializedName("PRICE") val PRICE: String,
)