package com.example.axon_test.navigation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.axon_test.R
import com.example.domain.entity.User

class NavigatorImpl : Navigator {

    override fun onBackPressed(activity: FragmentActivity, navController: NavController) {
        navController.popBackStack()
    }

    override fun onUserOpensProfile(
        activity: FragmentActivity,
        navController: NavController,
        user: User
    ) {
        navController.navigate(
            R.id.action_homeFragment_to_profileFragment,
            Bundle().apply {
//                putLong(EXTRA_ENTITY_ID, entityId)
            })
    }
}