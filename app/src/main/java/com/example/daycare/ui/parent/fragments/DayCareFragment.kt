package com.example.daycare.ui.parent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.daycare.R
import com.example.daycare.ui.parent.viewmodels.HomePageViewModel

abstract class DayCareFragment<T : ViewDataBinding>(val layout: Int) : Fragment() {
    lateinit var binding: T

    abstract fun doOnCreateView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, layout, container, false
        )
        doOnCreateView()
        return binding.root
    }
}