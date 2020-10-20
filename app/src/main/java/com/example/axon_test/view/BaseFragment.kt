package com.example.axon_test.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.axon_test.navigation.Navigator
import com.example.axon_test.utils.lazyThreadSafetyNone
import com.example.axon_test.viewmodel.BaseViewModel
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<V : BaseViewModel> : DaggerFragment() {

    abstract val viewModelClass: Class<V>

    abstract val layoutRes: Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: Navigator

    protected val viewModel by lazyThreadSafetyNone {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }

    protected lateinit var activity: DaggerAppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as DaggerAppCompatActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    protected abstract fun initView()

    protected abstract fun initObservers()

    protected abstract fun initListeners()
}
