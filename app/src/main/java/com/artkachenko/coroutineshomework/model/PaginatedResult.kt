package com.artkachenko.coroutineshomework.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class PaginatedResult <T>(
    val page: Int ?= 1,
    val results: List<T> ?= null
)