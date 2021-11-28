package com.example.daycare.domain.usecases

import com.example.daycare.domain.models.Child
import com.example.daycare.domain.repositories.ChildrenRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadChildrenUseCase @Inject constructor(private val childrenRepository: ChildrenRepository) {
    fun execute(onSuccess: (List<Child>) -> Unit) {
        GlobalScope.launch {
            val children = childrenRepository.listChildren().await()
            onSuccess(children)
        }
    }
}