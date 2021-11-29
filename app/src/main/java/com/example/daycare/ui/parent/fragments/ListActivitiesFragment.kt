package com.example.daycare.ui.parent.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.daycare.R
import com.example.daycare.databinding.ListActivitiesFragmentBinding
import com.example.daycare.ui.parent.adapters.ActivitiesListAdapter
import com.example.daycare.ui.parent.viewmodels.ListActivitesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivitiesFragment :
    DayCareFragment<ListActivitiesFragmentBinding, ListActivitesViewModel>
        (R.layout.list_activities_fragment, ListActivitesViewModel::class.java) {

    override fun doOnCreateView() {
        addUpButtonClickListener()
        viewModel.getActivities()
        viewModel.activitesLiveData.observe(viewLifecycleOwner) {
            val adapter = ActivitiesListAdapter(it,viewModel.getTenant(),Glide.with(this),requireContext())
            binding.activitiesList.adapter = adapter
            binding.activitiesList.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun addUpButtonClickListener() {
        binding.upButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}