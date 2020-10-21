package com.example.axon_test.view

import com.example.axon_test.R
import com.example.axon_test.adapter.ItemListener
import com.example.axon_test.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.toolbar.*

class ProfileFragment : BaseFragment<ProfileViewModel>(), ItemListener {

    override val layoutRes = R.layout.fragment_home

    override val viewModelClass = ProfileViewModel::class.java

    override fun initView() {
        tvTitle.text = context?.getString(R.string.profile)
    }

    override fun initObservers() {}

    override fun initListeners() {}
}
