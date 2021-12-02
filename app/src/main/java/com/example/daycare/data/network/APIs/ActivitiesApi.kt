package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Activity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ActivitiesApi {
    @GET("parents/activities")
    fun listActivites(@Header("token") token:String,@Query("page") page:Int): Deferred<List<Activity>>
}