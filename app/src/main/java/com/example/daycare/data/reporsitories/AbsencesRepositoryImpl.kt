package com.example.daycare.data.reporsitories

import com.example.daycare.data.network.APIs.AbsencesApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Absence
import com.example.daycare.domain.repositories.AbsencesRepository
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class AbsencesRepositoryImpl @Inject constructor(
    val absencesApi: AbsencesApi,
    val preferences: Preferences
) : AbsencesRepository {

    override fun listAbsences(pageNumber: Int): Deferred<List<Absence>> {
        return absencesApi.listAbsences(preferences.getToken(), pageNumber)
    }
}