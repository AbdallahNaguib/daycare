package com.example.daycare.ui.parent.fragments

import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.daycare.Constants
import com.example.daycare.R
import com.example.daycare.data.network.APIs.ProfileApi
import com.example.daycare.databinding.HomepageFragmentBinding
import com.example.daycare.domain.models.Parent
import com.example.daycare.ui.models.HomePageAction
import com.example.daycare.ui.parent.adapters.HomePageAdapter
import com.example.daycare.ui.parent.viewmodels.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomePageFragment : DayCareFragment<HomepageFragmentBinding, HomePageViewModel>(
    R.layout.homepage_fragment,
    HomePageViewModel::class.java
) {
    var actionsList = ArrayList<HomePageAction>()
    lateinit var homePageAdapter: HomePageAdapter

    @Inject
    lateinit var profileApi: ProfileApi

    override fun doOnCreateView() {
        initActionsList()
        initActionsAdapter()
        loadUserProfile()
    }

    private fun initActionsAdapter() {
        homePageAdapter = HomePageAdapter(actionsList)
        binding.actionsList.adapter = homePageAdapter
        binding.actionsList.layoutManager = GridLayoutManager(requireContext(),2)
    }

    private fun initActionsList() {
        if (actionsList.isEmpty()) {
            actionsList.add(HomePageAction(R.drawable.activities, "Daily Activities") {
                navigateToActivites()
            })
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
    }

    private fun navigateToActivites() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_homePageFragment_to_listActivitiesFragment)
    }

    private fun loadUserProfile() {
        viewModel.parentLiveData.observe(viewLifecycleOwner) {
            binding.userName.text = it.name
            setProfilePic(it)
        }
        viewModel.loadProfile()
    }

    private fun setProfilePic(parent: Parent) {
        if (parent.image != null)
            Glide
                .with(this)
                // todo change demo to the real tenant
                .load(Constants.IMAGE_URL("demo", "small", parent.image!!))
                .centerCrop()
                .into(binding.profilePic)
    }
}