package com.example.daycare.ui.parent.viewmodels

import com.example.daycare.domain.models.Session
import com.example.daycare.domain.usecases.ListSessionsUseCase
import javax.inject.Inject

class ListSessionsViewModel @Inject constructor(val listSessionsUseCase: ListSessionsUseCase) :
    ListDataViewModel<Session>() {
    override fun listData() {
        listSessionsUseCase.execute(pageNumber++) {
            _data.postValue(it)
        }
    }
}