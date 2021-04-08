package com.artkachenko.detail.network

import com.artkachenko.core_api.dto.MovieDetail
import com.artkachenko.core_api.network.DetailNetworkRepository
import com.artkachenko.core_api.network.NetworkService
import javax.inject.Inject

class DetailNetworkRepositoryImpl @Inject constructor(private val service: NetworkService) :
    DetailNetworkRepository {
    override suspend fun getMovieDetail(id: Long): MovieDetail {
        return service.getMovieDetail(id)
    }
}