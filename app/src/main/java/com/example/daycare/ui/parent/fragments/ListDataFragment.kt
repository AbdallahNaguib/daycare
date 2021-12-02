package com.example.daycare.ui.parent.fragments

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daycare.R
import com.example.daycare.databinding.ListFragmentBinding
import com.example.daycare.domain.models.Activity
import com.example.daycare.ui.parent.adapters.ActivitiesListAdapter
import com.example.daycare.ui.parent.adapters.PaginatedListAdapter
import com.example.daycare.ui.parent.viewmodels.ListDataViewModel

abstract class ListDataFragment<DATA ,V : ListDataViewModel<DATA>>(
    viewModelClass: Class<V>
) : DayCareFragment<ListFragmentBinding, V>(R.layout.list_fragment, viewModelClass) {

    val data = ArrayList<DATA>()
    lateinit var adapter: PaginatedListAdapter<*,DATA>
    private var hasMore = true

    override fun doOnCreateView() {
        addUpButtonClickListener()
        viewModel.listData()
        addListenerToLoadMoreDataWhenBottomReached()
        initAdapter()
        addObservers()
    }

    abstract fun getAdapterObject():PaginatedListAdapter<*,DATA>

    private fun initAdapter() {
        adapter = getAdapterObject()
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addObservers() {
        viewModel.data.observe(viewLifecycleOwner) { it ->
            dataLoaded(it)
        }
    }

    private fun addListenerToLoadMoreDataWhenBottomReached() {
        binding.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) and hasMore) {
                    viewModel.listData()
                }
            }
        })
    }

    private fun dataLoaded(it: List<DATA>) {
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