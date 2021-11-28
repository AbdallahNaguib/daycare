package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Many
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "parent")
class Parent : Resource() {
    var username: String = ""
    var image: String = ""
    var name: String = ""
}

@JsonApi(type = "parents")
class ManyParent : Many<Parent>(){
    override fun getEmpty() = Parent()
}