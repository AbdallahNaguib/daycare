package com.example.daycare.ui.parent.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Child
import com.example.daycare.domain.usecases.LoadChildrenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListChildrenViewModel @Inject constructor(
    private val loadChildrenUseCase: LoadChildrenUseCase,
    private val preferences: Preferences
) :
    ViewModel() {

    var pageNumber: Int = 1
    private val _childrenLiveData = MutableLiveData<List<Child>>()
    val childrenLiveData = _childrenLiveData

    fun loadChildren() {
        loadChildrenUseCase.execute(pageNumber++) {
            childrenLiveData.postValue(it)
        }
    }
    fun getTenant() = preferences.getTenant()

}