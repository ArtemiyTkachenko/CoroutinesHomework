package com.artkachenko.main.network

import com.artkachenko.core_api.dto.Movie
import com.artkachenko.core_api.dto.PaginatedResult
import com.artkachenko.core_api.network.MainNetworkRepository
import com.artkachenko.core_api.network.NetworkService
import javax.inject.Inject

class MainNetworkRepositoryImpl @Inject constructor(private val service: NetworkService) :
    MainNetworkRepository {
    override suspend fun getMovieList(page: Int): PaginatedResult<Movie> {
        return service.getMoviesList(page)
    }
}