package com.example.daycare.ui.parent.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daycare.R
import com.example.daycare.databinding.HomepageFragmentBinding
import com.example.daycare.databinding.ListFragmentBinding
import com.example.daycare.domain.models.Activity
import com.example.daycare.domain.models.Child
import com.example.daycare.ui.parent.adapters.ActivitiesListAdapter
import com.example.daycare.ui.parent.adapters.ChildrenListAdapter
import com.example.daycare.ui.parent.adapters.PaginatedListAdapter
import com.example.daycare.ui.parent.viewmodels.ListChildrenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListChildrenFragment :
    ListDataFragment<Child, ListChildrenViewModel>(
        ListChildrenViewModel::class.java
    ) {

    override fun getAdapterObject() = ChildrenListAdapter(
        data,
        Glide.with(this),
        viewModel.getTenant(),
    )
}