package com.example.daycare.domain.repositories

import com.example.daycare.domain.models.Activity
import kotlinx.coroutines.Deferred

interface ActivitesRepository {
    fun listActivities():Deferred<List<Activity>>
}