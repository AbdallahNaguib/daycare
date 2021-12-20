package com.example.daycare.ui.parent.fragments

import com.example.daycare.domain.models.Material
import com.example.daycare.ui.parent.adapters.MaterialsListAdapter
import com.example.daycare.ui.parent.viewmodels.ListMaterialsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListMaterialsFragment :
    ListDataFragment<Material, ListMaterialsViewModel>(ListMaterialsViewModel::class.java) {
    override fun getAdapterObject() = MaterialsListAdapter(requireContext(),data)
}