package com.example.daycare.domain.usecases

import com.example.daycare.domain.models.Activity
import com.example.daycare.domain.repositories.ActivitesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListActivitesUseCase @Inject constructor(private val activitesRepository: ActivitesRepository) {
    fun execute(pageNumber: Int, onSuccess: (List<Activity>) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val activities = activitesRepository.listActivities(pageNumber).await()
            onSuccess(activities)
        }
    }
}