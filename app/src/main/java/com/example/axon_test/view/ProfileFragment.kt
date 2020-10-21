package com.example.axon_test.view

import androidx.navigation.fragment.findNavController
import com.example.axon_test.R
import com.example.axon_test.adapter.ItemListener
import com.example.axon_test.utils.makeGone
import com.example.axon_test.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.toolbar.*
import timber.log.Timber

class ProfileFragment : BaseFragment<ProfileViewModel>(), ItemListener {

    override val layoutRes = R.layout.fragment_profile

    override val viewModelClass = ProfileViewModel::class.java

    override fun initView() {
        btnChangeView.makeGone()
        tvTitle.text = context?.getString(R.string.profile)
    }

    override fun initObservers() {}

    override fun initListeners() {
        btnBack.setOnClickListener {
            navigator.onBackPressed(activity, findNavController())
        }
    }
}
