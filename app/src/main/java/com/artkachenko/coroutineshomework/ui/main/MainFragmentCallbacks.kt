package com.artkachenko.coroutineshomework.ui.main

import com.artkachenko.coroutineshomework.model.Movie

interface MainFragmentCallbacks {

    fun getMovieDetails(movie: Movie)
}