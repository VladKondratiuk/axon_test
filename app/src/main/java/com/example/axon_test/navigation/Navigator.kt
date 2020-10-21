package com.example.axon_test.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController

interface Navigator {

    fun onBackPressed(activity: FragmentActivity, navController: NavController)

    fun onUserOpensProfile(activity: FragmentActivity, navController: NavController)
}