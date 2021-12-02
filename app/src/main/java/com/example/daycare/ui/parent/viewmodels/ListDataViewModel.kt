package com.example.daycare.ui.parent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class ListDataViewModel<DATA> : ViewModel() {
    protected var pageNumber = 1
    protected val _data = MutableLiveData<List<DATA>>()
    val data: LiveData<List<DATA>> = _data
    abstract fun listData()
}