package com.example.daycare.domain.usecases

import com.example.daycare.data.network.models.RequestResponse
import com.example.daycare.domain.handlers.ServerResponseUnauthorizedHandler
import retrofit2.Response
import timber.log.Timber

abstract class UseCase<T>{
    fun sendErrorCode(response:Response<out RequestResponse<T>>, handler: ServerResponseUnauthorizedHandler){
        when(response.code()){
            in 500..503 -> {
                handler.handle500sInternalServerErrors(response.code())
            }
            400,403,404 -> {
                handler.handle400sErrorsThatHaveMessagesToBeShown(response.code(),response.body()?.message)
            }
            401 -> {
                handler.handle401UnauthorizedError()
            }
        }
    }
}