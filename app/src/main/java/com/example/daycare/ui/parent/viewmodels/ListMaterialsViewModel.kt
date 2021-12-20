package com.example.daycare.ui.parent.viewmodels

import com.example.daycare.domain.models.Material
import com.example.daycare.domain.usecases.ListMaterialsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListMaterialsViewModel @Inject constructor(val listMaterialsUseCase: ListMaterialsUseCase) :
    ListDataViewModel<Material>() {
    override fun listData() {
        listMaterialsUseCase.execute(pageNumber++) {
            _data.postValue(it)
        }
    }
}