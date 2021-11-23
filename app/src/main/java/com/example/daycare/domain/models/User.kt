package com.example.daycare.domain.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(var username:String,var tenant:String?,var image:String,var name:String)