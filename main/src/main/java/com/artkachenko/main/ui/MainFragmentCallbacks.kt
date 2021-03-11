package com.artkachenko.main.ui

import com.artkachenko.core_api.dto.Movie

interface MainFragmentCallbacks {

    fun getMovieDetails(movie: Movie)
}