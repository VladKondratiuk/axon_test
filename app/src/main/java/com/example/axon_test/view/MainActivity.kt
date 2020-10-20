package com.example.axon_test.view

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.axon_test.R
import com.example.axon_test.navigation.Navigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentTransaction = childFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragment_container, fragment.cast())
//        fragmentTransaction.commit()
//    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: Navigator

    private var currentNavController: LiveData<NavController>? = null

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}