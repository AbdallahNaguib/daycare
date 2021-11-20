package com.example.daycare.parent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daycare.R
import com.example.daycare.databinding.HomepageFragmentBinding
import com.example.daycare.models.HomePageAction
import com.example.daycare.parent.adapters.HomePageAdapter

class HomePageFragment : Fragment(){
    var actionsList = ArrayList<HomePageAction>()
    private lateinit var binding: HomepageFragmentBinding
    lateinit var homePageAdapter: HomePageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.homepage_fragment, container, false)
        initActionsList()
        initActionsAdapter()
        return binding.root
    }

    private fun initActionsAdapter() {
        homePageAdapter = HomePageAdapter(actionsList)
        binding.actionsList.adapter = homePageAdapter
        binding.actionsList.layoutManager = GridLayoutManager(requireContext(),2)
    }

    private fun initActionsList(){
        actionsList.add(HomePageAction(R.drawable.activities,"Daily Activities"))
        actionsList.add(HomePageAction(R.drawable.my_children,"My children"))
        actionsList.add(HomePageAction(R.drawable.absences,"Absences"))
        actionsList.add(HomePageAction(R.drawable.certificates,"Certificates"))
        actionsList.add(HomePageAction(R.drawable.learning_material,"Learning Material"))
        actionsList.add(HomePageAction(R.drawable.online_class,"Online Sessions"))
        actionsList.add(HomePageAction(R.drawable.invoices,"Invoices"))
        actionsList.add(HomePageAction(R.drawable.calender,"Calendar"))
        actionsList.add(HomePageAction(R.drawable.event,"Events"))
        actionsList.add(HomePageAction(R.drawable.posts,"Posts"))
    }
}