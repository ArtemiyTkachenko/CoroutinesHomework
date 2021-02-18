package com.artkachenko.coroutineshomework.ui.detail

import com.artkachenko.coroutineshomework.base.BaseViewModel
import com.artkachenko.coroutineshomework.model.MovieDetail
import com.artkachenko.coroutineshomework.network.MovieRepository
import com.artkachenko.coroutineshomework.utils.debugLog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val movieRepository: MovieRepository): BaseViewModel() {

    private val _movie = MutableStateFlow<MovieDetail?>(null)

    private var page = 1

    val movie: StateFlow<MovieDetail?>
        get() = _movie

    fun getMovieDetail(id: Long) {
        scope.launch {
            val movie = movieRepository.getMovieDetail(id)
            debugLog("movie is $movie")
            _movie.emit(movie)
        }
    }
}