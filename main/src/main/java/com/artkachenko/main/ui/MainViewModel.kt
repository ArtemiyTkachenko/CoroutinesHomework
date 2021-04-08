package com.artkachenko.main.ui

import com.artkachenko.core_api.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.artkachenko.core_api.dto.Movie
import com.artkachenko.core_api.network.MainNetworkRepository
import com.artkachenko.utils.debugLog
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val movieRepository: MainNetworkRepository) : BaseViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(mutableListOf())

    private var page = 1

    val movies: StateFlow<List<Movie>>
        get() = _movies

    init {
        getMovies()
    }

    fun loadMore() {
        page++
        getMovies()
    }

    private fun getMovies() {
        scope.launch {
            val result = movieRepository.getMovieList(page = page)
            debugLog("list is ${result.results}")
            result.results?.let { _movies.emit(it) }
        }
    }
}