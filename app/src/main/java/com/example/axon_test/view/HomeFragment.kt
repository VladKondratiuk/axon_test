package com.example.axon_test.view

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.axon_test.R
import com.example.axon_test.adapter.Adapter
import com.example.axon_test.adapter.ItemListener
import com.example.axon_test.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeViewModel>(), ItemListener {

    override val layoutRes = R.layout.fragment_home

    override val viewModelClass = HomeViewModel::class.java

    private val adapter by lazy { Adapter(this) }

    override fun initView() {
        recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler_view.adapter = adapter
    }

    override fun initObservers() {
        viewModel.items.observe(this, {
            adapter.resetItems(it)
        })
    }

    override fun initListeners() {}
}
