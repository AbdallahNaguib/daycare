package com.example.daycare.data.reporsitories

import com.example.daycare.data.network.APIs.ProfileApi
import com.example.daycare.data.network.models.GetProfileResponse
import com.example.daycare.data.network.models.RequestResponse
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.User
import com.example.daycare.domain.repositories.ProfileRepository
import kotlinx.coroutines.Deferred
import retrofit2.Response
import timber.log.Timber

class ProfileRepositoryImpl(
    val profileApi: ProfileApi,
    val preferences: Preferences
) : ProfileRepository {

    override fun loadProfile(): Deferred<Response<GetProfileResponse>> {
        return profileApi.getProfile(preferences.getToken())
    }
}