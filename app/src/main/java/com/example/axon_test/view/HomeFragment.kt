package com.example.axon_test.view

import com.example.axon_test.R
import com.example.axon_test.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val layoutRes = R.layout.fragment_home

    override val viewModelClass = HomeViewModel::class.java

    override fun initObservers() {
        initListeners()
    }

    override fun initView() {}

    override fun initListeners() {}
}