package com.example.daycare.ui.parent.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.daycare.R
import com.example.daycare.databinding.ListActivitiesFragmentBinding
import com.example.daycare.domain.models.Activity
import com.example.daycare.ui.parent.adapters.ActivitiesListAdapter
import com.example.daycare.ui.parent.viewmodels.ListActivitesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivitiesFragment :
    DayCareFragment<ListActivitiesFragmentBinding, ListActivitesViewModel>
        (R.layout.list_activities_fragment, ListActivitesViewModel::class.java) {

    val activites = ArrayList<Activity>()
    lateinit var adapter: ActivitiesListAdapter
    override fun doOnCreateView() {
        addUpButtonClickListener()
        viewModel.getActivities()
        initAdapter()
        addObservers()
    }

    private fun initAdapter() {
        adapter =
            ActivitiesListAdapter(
                activites,
                viewModel.getTenant(),
                Glide.with(this),
                requireContext()
            ) {
                viewModel.getActivities()
            }
        binding.activitiesList.adapter = adapter
        binding.activitiesList.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addObservers() {
        viewModel.activitesLiveData.observe(viewLifecycleOwner) {
            adapter.addMoreData(it)
        }
    }

    private fun addUpButtonClickListener() {
        binding.upButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}