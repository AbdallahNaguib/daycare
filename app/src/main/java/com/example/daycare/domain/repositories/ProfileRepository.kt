package com.example.daycare.domain.repositories

import com.example.daycare.data.network.models.GetProfileResponse
import com.example.daycare.domain.models.Parent
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface ProfileRepository {
    fun loadProfile(): Deferred<Parent>
}