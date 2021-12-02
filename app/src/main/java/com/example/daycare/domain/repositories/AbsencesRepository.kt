package com.example.daycare.domain.repositories

import com.example.daycare.domain.models.Absence
import kotlinx.coroutines.Deferred

interface AbsencesRepository {
    fun listAbsences(pageNumber:Int):Deferred<List<Absence>>
}