package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource
import com.example.daycare.moshiJsonapi.core.ResourceIdentifier

@JsonApi(type = "groups")
class Group : Resource() {
    var title: String = ""
    var image: String = ""
}