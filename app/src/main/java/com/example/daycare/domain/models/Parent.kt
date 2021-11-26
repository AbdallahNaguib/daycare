package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource
import com.squareup.moshi.Json

@JsonApi(type = "parent")
data class Parent(var username:String, var image:String, var name:String) : Resource()