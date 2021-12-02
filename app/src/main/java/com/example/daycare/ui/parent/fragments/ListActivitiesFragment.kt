package com.example.daycare.ui.parent.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daycare.R
import com.example.daycare.databinding.ListFragmentBinding
import com.example.daycare.domain.models.Activity
import com.example.daycare.ui.parent.adapters.ActivitiesListAdapter
import com.example.daycare.ui.parent.adapters.PaginatedListAdapter
import com.example.daycare.ui.parent.viewmodels.ListActivitesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListActivitiesFragment :
    ListDataFragment<Activity, ListActivitesViewModel>
        (ListActivitesViewModel::class.java) {

    override fun getAdapterObject() = ActivitiesListAdapter(
        data,
        viewModel.getTenant(),
        Glide.with(this),
        requireContext()
    )

}