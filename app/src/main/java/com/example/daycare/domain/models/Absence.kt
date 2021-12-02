package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "absence")
class Absence : Resource(){
    var date: String? = null
    var comment: String? = null
    var group: Group = Group()
    var child: Child = Child()
}