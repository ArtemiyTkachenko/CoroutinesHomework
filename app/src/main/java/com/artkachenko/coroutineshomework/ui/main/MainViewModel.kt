package com.artkachenko.coroutineshomework.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artkachenko.coroutineshomework.base.BaseViewModel
import com.artkachenko.coroutineshomework.model.Movie
import com.artkachenko.coroutineshomework.network.MovieClient
import com.artkachenko.coroutineshomework.network.MovieService
import com.artkachenko.coroutineshomework.utils.debugLog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

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
            val result = MovieClient.service.getMoviesList(page = page)
            debugLog("list is ${result.results}")
            result.results?.let { _movies.emit(it) }
        }
    }
}