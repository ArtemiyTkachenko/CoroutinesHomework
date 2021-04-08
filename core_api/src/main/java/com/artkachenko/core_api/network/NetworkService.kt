package com.artkachenko.core_api.network

import com.artkachenko.core_api.dto.Movie
import com.artkachenko.core_api.dto.MovieDetail
import com.artkachenko.core_api.dto.PaginatedResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org"
const val API_KEY = "ac90a902531e410dae6a0f11e41fbccb"

interface NetworkService {
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