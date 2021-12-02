package com.example.daycare.ui.parent.fragments

import com.example.daycare.domain.models.Absence
import com.example.daycare.ui.parent.adapters.AbsencesListAdapter
import com.example.daycare.ui.parent.viewmodels.ListAbsencesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListAbsencesFragment :
    ListDataFragment<Absence, ListAbsencesViewModel>(
        ListAbsencesViewModel::class.java
    ) {
    override fun getAdapterObject() = AbsencesListAdapter(data)
}