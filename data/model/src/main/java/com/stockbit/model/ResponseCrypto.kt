package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class ResponseCrypto(
    @SerializedName("Data") val Data: List<DataCrypto>,
)
