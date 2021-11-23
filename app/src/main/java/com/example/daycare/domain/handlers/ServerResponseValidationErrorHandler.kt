package com.example.daycare.domain.handlers

import com.example.daycare.domain.models.ErrorResponse

interface ServerResponseValidationErrorHandler : ServerResponseHandler {
    /*
        422 : this means there is some missing fields (Validation error)
     */
    fun handle422Error(errorResponse: ErrorResponse?)
}