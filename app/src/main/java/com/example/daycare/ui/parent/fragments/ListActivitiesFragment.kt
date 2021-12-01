package com.example.daycare.ui.parent.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daycare.R
import com.example.daycare.databinding.ListFragmentBinding
import com.example.daycare.domain.models.Activity
import com.example.daycare.ui.parent.adapters.ActivitiesListAdapter
import com.example.daycare.ui.parent.viewmodels.ListActivitesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListActivitiesFragment :
    DayCareFragment<ListFragmentBinding, ListActivitesViewModel>
        (R.layout.list_fragment, ListActivitesViewModel::class.java) {

    val activites = ArrayList<Activity>()
    lateinit var adapter: ActivitiesListAdapter
    private var hasMore = true
    override fun doOnCreateView() {
        addUpButtonClickListener()
        viewModel.getActivities()
        addListenerToLoadMoreDataWhenBottomReached()
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
            )
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addObservers() {
        viewModel.activitesLiveData.observe(viewLifecycleOwner) { it ->
            activitiesLoaded(it)
        }
    }

    private fun addListenerToLoadMoreDataWhenBottomReached() {
        binding.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) and hasMore) {
                    viewModel.getActivities()
                }
            }
        })
    }

    private fun activitiesLoaded(it: List<Activity>) {
        if (it.isEmpty()) {
            hasMore = false
        } else {
            adapter.addMoreData(it)
        }
    }

    private fun addUpButtonClickListener() {
        binding.upButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}