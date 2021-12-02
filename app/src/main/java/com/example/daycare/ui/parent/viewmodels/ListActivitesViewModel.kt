package com.example.daycare.ui.parent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Activity
import com.example.daycare.domain.usecases.ListActivitesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListActivitesViewModel @Inject constructor(
    private val preferences: Preferences,
    private val listActivitesUseCase: ListActivitesUseCase) :
    ListDataViewModel<Activity>() {

    override fun listData() {
        listActivitesUseCase.execute(pageNumber++) {
            _data.postValue(it)
        }
    }
    fun getTenant():String{
        return preferences.getTenant()
    }
}