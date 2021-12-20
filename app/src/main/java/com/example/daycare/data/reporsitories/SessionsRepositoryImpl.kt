package com.example.daycare.data.reporsitories

import com.example.daycare.data.network.APIs.MaterialsApi
import com.example.daycare.data.network.APIs.SessionsApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Session
import com.example.daycare.domain.repositories.SessionsRepository
import kotlinx.coroutines.Deferred

class SessionsRepositoryImpl(val sessionsApi: SessionsApi,val preferences: Preferences) : SessionsRepository{
    override fun listSessions(pageNumber: Int): Deferred<List<Session>> {
        return sessionsApi.listSessions(pageNumber,preferences.getToken())
    }
}