package com.artkachenko.core_api.network

import com.artkachenko.core_api.dto.Movie
import com.artkachenko.core_api.dto.MovieDetail
import com.artkachenko.core_api.dto.PaginatedResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkProvider  {

    fun provideService() : NetworkService
}