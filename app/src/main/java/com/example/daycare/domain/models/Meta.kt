package com.example.daycare.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/*
"current_page": 1,
        "from": 1,
        "last_page": 1,
        "path": "https://app.360daycare.com/api/v2/parents/activities",
        "per_page": "10",
        "to": 3,
        "total": 3
 */
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