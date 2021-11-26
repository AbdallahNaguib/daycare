package com.example.daycare.domain.usecases

import com.example.daycare.domain.handlers.ServerResponseUnauthorizedHandler
import com.example.daycare.domain.models.Parent
import com.example.daycare.domain.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) :
    UseCase<Parent>() {

    fun execute(handler: ServerResponseUnauthorizedHandler,onSuccess: (Parent?) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = profileRepository.loadProfile().await()
            if (response.isSuccessful){
                val user = response.body()?.data
                user?.tenant = response.body()?.tenant
                onSuccess(user)
            }
            else{
                sendErrorCode(response, handler)
            }
        }
    }
}