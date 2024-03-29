package com.example.daycare.ui.parent.fragments

import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.daycare.Constants
import com.example.daycare.R
import com.example.daycare.databinding.HomepageFragmentBinding
import com.example.daycare.domain.models.Parent
import com.example.daycare.ui.models.HomePageAction
import com.example.daycare.ui.parent.adapters.HomePageAdapter
import com.example.daycare.ui.parent.viewmodels.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : DayCareFragment<HomepageFragmentBinding, HomePageViewModel>(
    R.layout.homepage_fragment,
    HomePageViewModel::class.java
) {
    var actionsList = ArrayList<HomePageAction>()
    lateinit var homePageAdapter: HomePageAdapter

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
            actionsList.add(HomePageAction(R.drawable.my_children, "My children") {
                navigateToChildren()
            })
            actionsList.add(HomePageAction(R.drawable.absences, "Absences") {
                navigateToAbsences()
            })
            actionsList.add(HomePageAction(R.drawable.learning_material, "Learning Material") {
                navigateToMaterials()
            })
            actionsList.add(HomePageAction(R.drawable.online_class, "Online Sessions"))
            actionsList.add(HomePageAction(R.drawable.invoices, "Invoices"))
            actionsList.add(HomePageAction(R.drawable.calender, "Calendar"))
            actionsList.add(HomePageAction(R.drawable.event, "Events"))
        }
    }

    private fun navigateToMaterials() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_homePageFragment_to_listMaterialsFragment)
    }

    private fun navigateToAbsences() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_homePageFragment_to_listAbsencesFragment)
    }

    private fun navigateToChildren() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_homePageFragment_to_listChildrenFragment)
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
                .load(Constants.IMAGE_URL(parent.tenant!!, "small", parent.image!!))
                .centerCrop()
                .into(binding.profilePic)
    }
}