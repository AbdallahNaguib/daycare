package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.HasOne
import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "activities")
class Activity : Resource() {
    var date: String? = null
    var time: String? = null
    private var child:HasOne<Child>? = null

    fun getChild() = child?.get(document)
}