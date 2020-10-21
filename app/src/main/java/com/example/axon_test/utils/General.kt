package com.example.axon_test.utils

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController

fun <T> lazyThreadSafetyNone(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)

fun NavController.navigate(@IdRes resId: Int, args: Bundle? = null) {
    currentDestination?.getAction(resId)?.let { navigate(resId, args) }
}