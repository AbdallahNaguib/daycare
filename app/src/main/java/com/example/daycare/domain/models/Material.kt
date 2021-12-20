package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "learning_materials")
class Material : Resource() {
    var title: String? = null
    var attachment: String? = null
    var group = Group()
    var subject = Subject()
}