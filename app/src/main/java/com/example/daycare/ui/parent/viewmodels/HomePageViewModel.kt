package com.example.daycare.ui.parent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daycare.domain.handlers.ServerResponseUnauthorizedHandler
import com.example.daycare.domain.models.Parent
import com.example.daycare.domain.usecases.LoadProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(val loadProfileUseCase: LoadProfileUseCase) :
    ViewModel(), ServerResponseUnauthorizedHandler {
    private val userMutableLiveData = MutableLiveData<Parent>()
    val parentLiveData: LiveData<Parent> = userMutableLiveData
    fun loadProfile() {
        loadProfileUseCase.execute(this) { user ->
            userMutableLiveData.postValue(user)
        }
    }

    override fun handle401UnauthorizedError() {
        TODO("Not yet implemented")
    }

    override fun handle500sInternalServerErrors(errorCode: Int) {
        TODO("Not yet implemented")
    }

    override fun handle400sErrorsThatHaveMessagesToBeShown(errorCode: Int, message: String?) {
        TODO("Not yet implemented")
    }
}