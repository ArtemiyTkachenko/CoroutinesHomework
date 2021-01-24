package com.artkachenko.coroutineshomework.network

import com.artkachenko.coroutineshomework.BuildConfig
import com.artkachenko.coroutineshomework.model.Movie
import com.artkachenko.coroutineshomework.model.PaginatedResult
import com.artkachenko.coroutineshomework.utils.BASE_URL
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object MovieClient {

    private val okHttpClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        val headerInterceptor = HeaderInterceptor()
        OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(
                if (BuildConfig.DEBUG) loggingInterceptor.setLevel(
                    HttpLoggingInterceptor.Level.BODY
                ) else loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
            )
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service by lazy {
        retrofit.create(MovieService::class.java)
    }
}