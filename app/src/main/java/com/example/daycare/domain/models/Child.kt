package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "child")
class Child : Resource() {
    var name: String? = null
    var id_number: String? = null
    var birth_date: String? = null
    var blood_type: String? = null
    var image: String? = null
    var group: Group = Group()
    var parents = ManyParent()
}