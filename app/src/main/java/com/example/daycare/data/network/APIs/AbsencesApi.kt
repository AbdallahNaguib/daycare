package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Absence
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AbsencesApi {
    @GET("parents/absences")
    fun listAbsences(
        @Header("token") token: String,
        @Query("page") pageNumber: Int
    ): Deferred<List<Absence>>
}