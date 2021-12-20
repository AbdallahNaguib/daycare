package com.example.daycare.domain.repositories

import com.example.daycare.domain.models.Material
import kotlinx.coroutines.Deferred

interface MaterialsRepository {
    fun listMaterials(pageNumber:Int):Deferred<List<Material>>
}