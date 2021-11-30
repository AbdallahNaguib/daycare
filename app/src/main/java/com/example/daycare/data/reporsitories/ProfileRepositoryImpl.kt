package com.example.daycare.data.reporsitories

import com.example.daycare.data.network.APIs.ProfileApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Parent
import com.example.daycare.domain.repositories.ProfileRepository
import kotlinx.coroutines.Deferred

class ProfileRepositoryImpl(
    val profileApi: ProfileApi,
    val preferences: Preferences
) : ProfileRepository {

    override fun loadProfile(): Deferred<Parent> {
        return profileApi.getProfile(preferences.getToken())
    }
}