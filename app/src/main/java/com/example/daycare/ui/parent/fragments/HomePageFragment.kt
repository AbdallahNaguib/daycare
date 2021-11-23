package com.example.daycare.ui.parent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.daycare.Constants
import com.example.daycare.R
import com.example.daycare.ui.models.HomePageAction
import com.example.daycare.ui.parent.adapters.HomePageAdapter
import com.example.daycare.ui.parent.viewmodels.HomePageViewModel
import com.example.daycare.data.network.APIs.ProfileApi
import com.example.daycare.databinding.HomepageFragmentBinding
import com.example.daycare.domain.models.User
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomePageFragment : DayCareFragment<HomepageFragmentBinding>(R.layout.homepage_fragment) {
    var actionsList = ArrayList<HomePageAction>()
    lateinit var homePageAdapter: HomePageAdapter
    lateinit var viewModel: HomePageViewModel

    @Inject
    lateinit var profileApi: ProfileApi

    override fun doOnCreateView() {
        viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)
        initActionsList()
        initActionsAdapter()
        loadUserProfile()
    }

    private fun initActionsAdapter() {
        homePageAdapter = HomePageAdapter(actionsList)
        binding.actionsList.adapter = homePageAdapter
        binding.actionsList.layoutManager = GridLayoutManager(requireContext(),2)
    }

    private fun initActionsList(){
        actionsList.add(HomePageAction(R.drawable.activities,"Daily Activities"))
        actionsList.add(HomePageAction(R.drawable.my_children, "My children"))
        actionsList.add(HomePageAction(R.drawable.absences, "Absences"))
        actionsList.add(HomePageAction(R.drawable.certificates, "Certificates"))
        actionsList.add(HomePageAction(R.drawable.learning_material, "Learning Material"))
        actionsList.add(HomePageAction(R.drawable.online_class, "Online Sessions"))
        actionsList.add(HomePageAction(R.drawable.invoices, "Invoices"))
        actionsList.add(HomePageAction(R.drawable.calender, "Calendar"))
        actionsList.add(HomePageAction(R.drawable.event, "Events"))
        actionsList.add(HomePageAction(R.drawable.posts, "Posts"))
    }

    private fun loadUserProfile() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            binding.userName.text = it.name
            setProfilePic(it)
        }
        viewModel.loadProfile()
    }

    private fun setProfilePic(user: User) {
        Glide
            .with(this)
            .load(Constants.IMAGE_URL(user.tenant!!,"small",user.image))
            .centerCrop()
            .into(binding.profilePic)
    }
}