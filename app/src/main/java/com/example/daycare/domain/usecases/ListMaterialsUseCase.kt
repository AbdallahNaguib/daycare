package com.example.daycare.domain.usecases

import com.example.daycare.domain.models.Material
import com.example.daycare.domain.repositories.MaterialsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListMaterialsUseCase @Inject constructor(val materialsRepository: MaterialsRepository) {
    fun execute(pageNumber: Int, onSuccess: (List<Material>) -> Unit) {
        GlobalScope.launch {
            onSuccess(materialsRepository.listMaterials(pageNumber).await())
        }
    }
}