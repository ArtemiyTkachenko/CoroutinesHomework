package com.artkachenko.core_api.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PaginatedResult <T>(
    val page: Int ?= 1,
    val results: List<T> ?= null
)