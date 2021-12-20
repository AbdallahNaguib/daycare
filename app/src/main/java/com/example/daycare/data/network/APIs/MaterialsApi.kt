package com.example.daycare.data.network.APIs

import com.example.daycare.domain.models.Material
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MaterialsApi {
    @GET("parents/learning-materials")
    fun listMaterials(@Query("page") pageNumber:Int,@Header("token") token:String):Deferred<List<Material>>
}