package com.example.daycare.data.reporsitories

import com.example.daycare.data.network.APIs.ChildrenApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.domain.models.Child
import com.example.daycare.domain.repositories.ChildrenRepository
import kotlinx.coroutines.Deferred

class ChildrenRepositoryImpl(val childrenApi: ChildrenApi, val preferences: Preferences) :
    ChildrenRepository {

    override fun listChildren(page:Int): Deferred<List<Child>> {
        return childrenApi.getChildren(preferences.getToken(),page)
    }

}