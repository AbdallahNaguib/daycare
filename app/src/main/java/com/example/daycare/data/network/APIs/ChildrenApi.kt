package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Child
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ChildrenApi {
    @GET("parents/children")
    fun getChildren(@Header("token") token:String,@Query("page") page:Int):Deferred<List<Child>>
}