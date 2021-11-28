package com.example.daycare.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "current_page") val currentPage: Int,
    val from: Int,
    @Json(name = "last_page") val lastPage: Int,
    val path: String,
    @Json(name = "per_page") val perPage: String,
    val to: Int,
    val total: Int
)