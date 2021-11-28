package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Child
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header

interface ChildrenApi {
    @GET("parents/children")
    fun getChildren(@Header("token") token:String):Deferred<List<Child>>
}