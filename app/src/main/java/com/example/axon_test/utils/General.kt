package com.example.axon_test.utils

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.NavController
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

private const val pattern = "YYYY-mm-dd"

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

fun String.toYearMonthDay(): String =
    OffsetDateTime.parse(this).format(DateTimeFormatter.ofPattern(pattern))