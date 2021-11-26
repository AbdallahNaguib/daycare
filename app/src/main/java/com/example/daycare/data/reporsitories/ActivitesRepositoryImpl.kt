package com.example.daycare.data.reporsitories

import com.example.daycare.data.network.APIs.ActivitiesApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Activity
import com.example.daycare.domain.repositories.ActivitesRepository
import kotlinx.coroutines.Deferred

class ActivitesRepositoryImpl(val activitiesApi: ActivitiesApi, val preferences: Preferences) :
    ActivitesRepository {
    override fun listActivities(): Deferred<List<Activity>> {
        return activitiesApi.listActivites(preferences.getToken())
    }
}