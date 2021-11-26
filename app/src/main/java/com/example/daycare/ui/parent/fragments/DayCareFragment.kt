package com.example.daycare.ui.parent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class DayCareFragment<T : ViewDataBinding, V : ViewModel>(
    private val layout: Int,
    private val viewModelClass: Class<V>
) : Fragment() {
    lateinit var binding: T
    lateinit var viewModel: V

    abstract fun doOnCreateView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, layout, container, false
        )
        viewModel = ViewModelProvider(this).get(viewModelClass)
        doOnCreateView()
        return binding.root
    }
}