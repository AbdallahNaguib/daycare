package com.example.daycare.ui.parent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daycare.domain.models.Absence
import com.example.daycare.domain.usecases.ListAbsencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListAbsencesViewModel @Inject constructor(val listAbsencesUseCase: ListAbsencesUseCase) :
    ListDataViewModel<Absence>() {

    override fun listData() {
        listAbsencesUseCase.execute(pageNumber++) {
            _data.postValue(it)
        }
    }
}