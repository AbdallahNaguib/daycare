package com.example.daycare.domain.handlers

interface ServerResponseUnauthorizedHandler : ServerResponseHandler{
    /*
        401 : unauthorized  // clear all user data and redirect to login screen
     */
    fun handle401UnauthorizedError()
}