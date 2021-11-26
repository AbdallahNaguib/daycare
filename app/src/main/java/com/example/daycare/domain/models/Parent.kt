package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "parent")
class Parent : Resource() {
    var username: String? = null
    var image: String? = null
    var name: String? = null
}