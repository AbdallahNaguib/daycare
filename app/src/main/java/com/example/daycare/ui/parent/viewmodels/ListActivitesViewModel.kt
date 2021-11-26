package com.example.daycare.ui.parent.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daycare.domain.models.Activity
import com.example.daycare.domain.usecases.ListActivitesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListActivitesViewModel @Inject constructor(private val listActivitesUseCase: ListActivitesUseCase) :
    ViewModel() {
    val activitesLiveData = MutableLiveData<List<Activity>>()

    fun getActivities() {
        listActivitesUseCase.execute {
            activitesLiveData.postValue(it)
        }
    }
}