package com.artkachenko.core_api.network

import com.artkachenko.core_api.dto.MovieDetail

interface DetailNetworkRepository {

    suspend fun getMovieDetail(id: Long): MovieDetail
}