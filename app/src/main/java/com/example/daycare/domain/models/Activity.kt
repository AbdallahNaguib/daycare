package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "activities")
class Activity : Resource() {
    var date: String? = null
    var time: String? = null
    var image: String? = null
    var child = Child()
    var group = Group()
    var other = HashMap<String,String>()
    var type = ActivityType()
}
