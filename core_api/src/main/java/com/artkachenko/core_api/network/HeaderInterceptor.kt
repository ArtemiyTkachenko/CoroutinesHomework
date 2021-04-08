package com.artkachenko.core_api.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header("Authorization", "Bearer $API_KEY")
            .header("Content-Type", "application/json;charset=utf-8")
            .build()
        return chain.proceed(request)
    }
}