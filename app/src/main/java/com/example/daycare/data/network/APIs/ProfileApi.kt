package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Parent
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApi {
    @GET("profile")
    fun getProfile(@Header("token") token:String): Deferred<Parent>
}