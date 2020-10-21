package com.example.axon_test.view

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.axon_test.R
import com.example.axon_test.adapter.Adapter
import com.example.axon_test.adapter.ItemListener
import com.example.axon_test.adapter.item.BaseItem
import com.example.axon_test.adapter.item.UserItem
import com.example.axon_test.utils.makeGone
import com.example.axon_test.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class HomeFragment : BaseFragment<HomeViewModel>(), ItemListener {

    override val layoutRes = R.layout.fragment_home

    override val viewModelClass = HomeViewModel::class.java

    private val itemListener = object : ItemListener {
        override fun onUserClick(item: UserItem) {
            viewModel.cacheUser(item.user)
        }
    }

    private val adapter = Adapter<BaseItem>(itemListener)

    override fun initView() {
        tvTitle.text = context?.getString(R.string.home)
        btnBack.makeGone()
        btnChangeView.makeGone()
        recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler_view.adapter = adapter
        swipe_refresh_layout.setOnRefreshListener { viewModel.refresh() }
    }

    override fun initObservers() {
        viewModel.items.observe(this, {
            adapter.submitList(it)
        })
        viewModel.onUserCached.observe(this, {
            navigator.onUserOpensProfile(activity, findNavController())
        })
        viewModel.loading.observe(this, {
            swipe_refresh_layout.isRefreshing = it
        })
    }

    override fun initListeners() {}
}
