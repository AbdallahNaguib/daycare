package com.example.daycare.domain.repositories

import com.example.daycare.data.network.models.GetProfileResponse
import com.example.daycare.data.network.models.RequestResponse
import com.example.daycare.domain.models.User
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface ProfileRepository {
    fun loadProfile(): Deferred<Response<GetProfileResponse>>
}