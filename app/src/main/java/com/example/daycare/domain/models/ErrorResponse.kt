package com.example.daycare.domain.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(val email:String, val password:String)
