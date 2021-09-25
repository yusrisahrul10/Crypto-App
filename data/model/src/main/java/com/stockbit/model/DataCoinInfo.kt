package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class DataCoinInfo(
    @SerializedName("Id") val Id: String,
    @SerializedName("Name") val Name: String,
    @SerializedName("FullName") val FullName: String,
)
