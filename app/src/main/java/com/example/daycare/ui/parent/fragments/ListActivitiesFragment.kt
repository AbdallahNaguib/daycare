package com.example.daycare.ui.parent.fragments

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daycare.R
import com.example.daycare.databinding.ListActivitiesFragmentBinding
import com.example.daycare.ui.parent.adapters.ActivitesListAdapter
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
            val adapter = ActivitesListAdapter(it)
            binding.activitiesList.adapter = adapter
            binding.activitiesList.adapter = adapter
            binding.activitiesList.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun addUpButtonClickListener() {
        binding.upButton.setOnClickListener {
            Toast.makeText(requireContext(), "here", Toast.LENGTH_SHORT).show()
        }
    }
}