package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "activities")
class Activity : Resource() {
    var date: String = ""
    var time: String = ""
    var image: String = ""
    var child: Child = Child()
    var group: Group = Group()
}