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
import com.example.daycare.ui.parent.viewmodels.ListChildrenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListChildrenFragment :
    DayCareFragment<ListFragmentBinding, ListChildrenViewModel>(
        R.layout.list_fragment,
        ListChildrenViewModel::class.java
    ) {

    val children = ArrayList<Child>()
    lateinit var adapter: ChildrenListAdapter
    private var hasMore = true
    override fun doOnCreateView() {
        addUpButtonClickListener()
        viewModel.loadChildren()
        addListenerToLoadMoreDataWhenBottomReached()
        initAdapter()
        addObservers()
    }

    private fun initAdapter() {
        adapter =
            ChildrenListAdapter(
                children,
                Glide.with(this),
                viewModel.getTenant(),
            )
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addObservers() {
        viewModel.childrenLiveData.observe(viewLifecycleOwner) {
            childrenLoaded(it)
        }
    }

    private fun addListenerToLoadMoreDataWhenBottomReached() {
        binding.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) and hasMore) {
                    viewModel.loadChildren()
                }
            }
        })
    }

    private fun childrenLoaded(it: List<Child>) {
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