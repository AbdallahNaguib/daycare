package com.example.daycare.domain.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(val next:String,val prev:String,val first:String,val last:String)