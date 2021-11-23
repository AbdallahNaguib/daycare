package com.example.daycare.domain.handlers

import com.example.daycare.domain.models.ErrorResponse

interface ServerResponseHandler {
    /*
        500 501 502 503
     */
    fun handle500sInternalServerErrors(errorCode: Int)

    /*
        400 403 404
     */
    fun handle400sErrorsThatHaveMessagesToBeShown(errorCode: Int, message: String?)
}