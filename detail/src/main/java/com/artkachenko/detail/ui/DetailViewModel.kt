package com.artkachenko.detail.ui

import com.artkachenko.core_api.base.BaseViewModel
import com.artkachenko.core_api.network.DetailNetworkRepository
import com.artkachenko.utils.debugLog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val movieRepository: DetailNetworkRepository): BaseViewModel() {

    private val _movie = MutableStateFlow<com.artkachenko.core_api.dto.MovieDetail?>(null)

    private var page = 1

    val movie: StateFlow<com.artkachenko.core_api.dto.MovieDetail?>
        get() = _movie

    fun getMovieDetail(id: Long) {
        scope.launch {
            val movie = movieRepository.getMovieDetail(id)
            debugLog("movie is $movie")
            _movie.emit(movie)
        }
    }
}