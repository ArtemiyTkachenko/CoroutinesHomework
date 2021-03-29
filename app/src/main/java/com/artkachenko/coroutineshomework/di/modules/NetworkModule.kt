package com.artkachenko.coroutineshomework.di.modules

import com.artkachenko.coroutineshomework.BuildConfig
import com.artkachenko.coroutineshomework.network.HeaderInterceptor
import com.artkachenko.coroutineshomework.network.MovieService
import com.artkachenko.coroutineshomework.utils.BASE_URL
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
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
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