package com.example.daycare.domain.usecases

import com.example.daycare.domain.models.Session
import com.example.daycare.domain.repositories.SessionsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListSessionsUseCase @Inject constructor(val sessionsRepository: SessionsRepository){
    fun execute(pageNumber:Int,onSuccess:(List<Session>)->Unit){
        GlobalScope.launch {
            onSuccess(sessionsRepository.listSessions(pageNumber).await())
        }
    }
}