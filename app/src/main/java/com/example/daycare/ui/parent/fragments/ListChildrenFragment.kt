package com.example.daycare.ui.parent.fragments

import com.example.daycare.R
import com.example.daycare.databinding.HomepageFragmentBinding
import com.example.daycare.ui.parent.viewmodels.ListChildrenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListChildrenFragment :
    DayCareFragment<HomepageFragmentBinding, ListChildrenViewModel>(
        R.layout.homepage_fragment,
        ListChildrenViewModel::class.java
    ) {
    override fun doOnCreateView() {
        viewModel.loadChildren()
    }
}