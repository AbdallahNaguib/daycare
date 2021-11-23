package com.example.daycare.data.network.models

import com.example.daycare.domain.models.ErrorResponse
import com.squareup.moshi.JsonClass

abstract class RequestResponse<T>{
    var data:T? = null
    var errors:ErrorResponse? = null
    var message:String? = null
}