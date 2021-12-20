package com.example.daycare.domain.models

import com.example.daycare.moshiJsonapi.core.JsonApi
import com.example.daycare.moshiJsonapi.core.Resource

@JsonApi(type = "online-sessions")
class Session : Resource() {
    var repeated_at = ArrayList<String>()
}