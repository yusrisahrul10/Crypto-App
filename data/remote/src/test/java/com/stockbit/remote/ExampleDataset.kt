package com.stockbit.remote

import com.stockbit.model.ResponseCrypto
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ExampleDataset {
//    val FAKE_EXAMPLE = listOf(
//        ExampleModel("1", "John")
//    )
    private fun providesHttpLoggingInterceptor() : HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = when (BuildConfig.DEBUG) {
            true -> HttpLoggingInterceptor.Level.BODY
            false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    fun providesHttpClient(
            interceptor: HttpLoggingInterceptor,
    ) : OkHttpClient {
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }.build()
    }

    private fun getRetrofit() : Retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.baseUrl)
        client(providesHttpClient(
                providesHttpLoggingInterceptor()
        ))
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
    }.build()

    fun getListCrypto(page: Int) : Single<ResponseCrypto> =
        getRetrofit().create(ApiService::class.java).getListCrypto("IDR", page)

}