package com.example.daycare.domain.usecases

import com.example.daycare.domain.models.Absence
import com.example.daycare.domain.repositories.AbsencesRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListAbsencesUseCase @Inject constructor(val absencesRepository: AbsencesRepository) {
    fun execute(pageNumber: Int, onSuccess: (List<Absence>) -> Unit) {
        GlobalScope.launch {
            val absences = absencesRepository.listAbsences(pageNumber).await()
            onSuccess(absences)
        }
    }
}