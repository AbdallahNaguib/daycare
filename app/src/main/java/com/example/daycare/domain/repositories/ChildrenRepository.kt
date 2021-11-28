package com.example.daycare.domain.repositories

import com.example.daycare.domain.models.Child
import kotlinx.coroutines.Deferred

interface ChildrenRepository {
    fun listChildren():Deferred<List<Child>>
}