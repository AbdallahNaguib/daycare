package com.example.daycare.data.network.APIs

import com.example.daycare.data.network.models.GetProfileResponse
import com.example.daycare.data.network.models.RequestResponse
import com.example.daycare.domain.models.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApi {
    @GET("profile")
    fun getProfile(@Header("token") token:String): Deferred<Response<GetProfileResponse>>
}