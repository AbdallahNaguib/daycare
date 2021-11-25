package com.example.daycare.ui.parent.fragments

import android.widget.Toast
import com.example.daycare.R
import com.example.daycare.databinding.ListActivitiesFragmentBinding

class ListActivitiesFragment : DayCareFragment<ListActivitiesFragmentBinding>(R.layout.list_activities_fragment){

    override fun doOnCreateView() {
        addUpButtonClickListener()
    }

    private fun addUpButtonClickListener() {
        binding.upButton.setOnClickListener {
            Toast.makeText(requireContext(), "here", Toast.LENGTH_SHORT).show()
        }
    }
}