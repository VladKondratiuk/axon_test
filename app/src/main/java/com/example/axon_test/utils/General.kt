package com.example.axon_test.utils

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.NavController

fun <T> lazyThreadSafetyNone(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)

fun NavController.navigate(@IdRes resId: Int, args: Bundle? = null) {
    currentDestination?.getAction(resId)?.let { navigate(resId, args) }
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInVisible() {
    this.visibility = View.INVISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}