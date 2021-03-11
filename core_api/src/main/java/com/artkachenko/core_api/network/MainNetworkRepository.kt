package com.artkachenko.core_api.network

import com.artkachenko.core_api.dto.Movie
import com.artkachenko.core_api.dto.PaginatedResult

interface MainNetworkRepository {

    suspend fun getMovieList(page: Int): PaginatedResult<Movie>
}