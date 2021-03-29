package com.artkachenko.coroutineshomework.network

import com.artkachenko.coroutineshomework.BuildConfig
import com.artkachenko.coroutineshomework.model.Movie
import com.artkachenko.coroutineshomework.model.MovieDetail
import com.artkachenko.coroutineshomework.model.PaginatedResult
import com.artkachenko.coroutineshomework.utils.BASE_URL
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

class MovieRepository @Inject constructor(private val movieService: MovieService) {

    suspend fun getMovieList(page: Int): PaginatedResult<Movie> {
        return movieService.getMoviesList(page)
    }

    suspend fun getMovieDetail(id: Long): MovieDetail {
        return movieService.getMovieDetail(id)
    }
}