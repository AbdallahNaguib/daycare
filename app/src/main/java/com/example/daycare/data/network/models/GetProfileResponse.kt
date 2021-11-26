package com.example.daycare.data.network.models

import com.example.daycare.domain.models.Parent
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GetProfileResponse:RequestResponse<Parent>(){
    var token:String? = null
    var tenant:String? = null
}