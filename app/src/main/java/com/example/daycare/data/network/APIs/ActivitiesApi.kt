package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Activity
import com.example.daycare.domain.models.Parent
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header

interface ActivitiesApi {
    @GET("parents/activities")
    fun listActivites(@Header("token") token:String): Deferred<List<Activity>>
}