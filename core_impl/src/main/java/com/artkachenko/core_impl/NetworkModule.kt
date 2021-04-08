package com.artkachenko.core_impl

import com.artkachenko.core_api.network.BASE_URL
import com.artkachenko.core_api.network.HeaderInterceptor
import com.artkachenko.core_api.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    fun provideMovieService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

    @Provides
    @Reusable
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        val headerInterceptor = HeaderInterceptor()
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(
                if (BuildConfig.DEBUG) loggingInterceptor.setLevel(
                    HttpLoggingInterceptor.Level.BODY
                ) else loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
            )
            .build()
    }

    @Provides
    @Reusable
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}