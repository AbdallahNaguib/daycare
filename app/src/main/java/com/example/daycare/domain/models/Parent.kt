package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Many
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "parent")
class Parent : Resource() {
    var username: String? = null
    var image: String? = null
    var name: String? = null

    val token: String?
        get() = document.getMore("token")
    val tenant: String?
        get() = document.getMore("tenant")
}

@JsonApi(type = "parents")
class ManyParent : Many<Parent>(){
    override fun getEmpty() = Parent()
}