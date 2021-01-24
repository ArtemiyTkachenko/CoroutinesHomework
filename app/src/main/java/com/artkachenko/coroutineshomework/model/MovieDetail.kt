package com.artkachenko.coroutineshomework.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class MovieDetail(
    val id: Long ?= null,
    @Json(name = "original_title") val title: String ?= null,
    @Json(name = "poster_path") val posterPath: String ?= null,
    val overview: String ?= null,
    @Json(name = "vote_average") val voteAverage: String ?= null,
    @Json(name = "vote_count") val voteCount: String ?= null
) : Parcelable