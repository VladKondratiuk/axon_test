package com.example.axon_test.view

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.axon_test.R
import com.example.axon_test.adapter.ItemListener
import com.example.axon_test.adapter.binding.UserBinder
import com.example.axon_test.utils.makeGone
import com.example.axon_test.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class ProfileFragment : BaseFragment<ProfileViewModel>(), ItemListener {

    override val layoutRes = R.layout.fragment_profile

    override val viewModelClass = ProfileViewModel::class.java

    override fun initView() {
        btnChangeView.makeGone()
        tvTitle.text = context?.getString(R.string.profile)
    }

    override fun initObservers() {
        viewModel.onCachedUserUpdate.observe(this, Observer {
            UserBinder.bindProfileUser(view ?: return@Observer, it)
        })
    }

    override fun initListeners() {
        btnBack.setOnClickListener {
            navigator.onBackPressed(activity, findNavController())
        }
        tvCellPhone.setOnClickListener {
            callTo(viewModel.onCachedUserUpdate.value?.phone)
        }
    }

    private fun callTo(number: String?) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }
}
