package com.stockbit.remote

import com.stockbit.model.ResponseCrypto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/top/totaltoptiervolfull")
    fun getListCrypto(
        @Query("tsym") tsym : String,
        @Query("page") page : Int
    ) : Single<ResponseCrypto>
}