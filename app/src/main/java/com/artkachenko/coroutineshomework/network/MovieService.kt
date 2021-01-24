package com.artkachenko.coroutineshomework.network

import com.artkachenko.coroutineshomework.model.Movie
import com.artkachenko.coroutineshomework.model.MovieDetail
import com.artkachenko.coroutineshomework.model.PaginatedResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("3/movie/now_playing")
    suspend fun getMoviesList(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "ac90a902531e410dae6a0f11e41fbccb"
    ): PaginatedResult<Movie>

    @GET("3/movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Long,
        @Query("api_key") apiKey: String = "ac90a902531e410dae6a0f11e41fbccb"
    ): MovieDetail
}