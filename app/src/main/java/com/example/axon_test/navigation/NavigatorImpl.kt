package com.example.axon_test.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.axon_test.R

class NavigatorImpl : Navigator {

    override fun onBackPressed(activity: FragmentActivity, navController: NavController) {
        navController.popBackStack()
    }

    override fun onUserOpensProfile(
        activity: FragmentActivity,
        navController: NavController
    ) {
        navController.navigate(R.id.action_homeFragment_to_profileFragment)
    }
}