package com.example.daycare.data.network.models

import com.example.daycare.domain.models.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GetProfileResponse:RequestResponse<User>(){
    var token:String? = null
    var tenant:String? = null
}