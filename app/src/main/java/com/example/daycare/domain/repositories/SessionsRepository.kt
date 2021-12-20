package com.example.daycare.domain.repositories

import com.example.daycare.domain.models.Session
import kotlinx.coroutines.Deferred

interface SessionsRepository {
    fun listSessions(pageNumber:Int):Deferred<List<Session>>
}