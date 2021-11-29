package com.example.daycare.ui.parent.viewmodels

import androidx.lifecycle.ViewModel
import com.example.daycare.domain.usecases.LoadChildrenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListChildrenViewModel @Inject constructor(private val loadChildrenUseCase: LoadChildrenUseCase) :
    ViewModel() {
    fun loadChildren(){
        loadChildrenUseCase.execute {
            Timber.d("$it")
            for(child in it){
                for(parent in child.parents){

                }
            }
        }
    }
}