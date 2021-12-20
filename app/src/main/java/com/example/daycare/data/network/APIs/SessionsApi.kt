package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Session
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SessionsApi {
    @GET("parents/online-sessions")
    fun listSessions(@Query("page") page:Int,@Header("token") token:String): Deferred<List<Session>>
}