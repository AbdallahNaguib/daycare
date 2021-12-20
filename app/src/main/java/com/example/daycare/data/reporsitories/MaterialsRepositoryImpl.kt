package com.example.daycare.data.reporsitories

import com.example.daycare.data.network.APIs.MaterialsApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Material
import com.example.daycare.domain.repositories.MaterialsRepository
import kotlinx.coroutines.Deferred

class MaterialsRepositoryImpl(val materialsApi: MaterialsApi, val preferences: Preferences) :
    MaterialsRepository {
    override fun listMaterials(pageNumber: Int): Deferred<List<Material>> {
        return materialsApi.listMaterials(pageNumber, preferences.getToken())
    }
}