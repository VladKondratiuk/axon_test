package com.example.axon_test.utils

import android.view.View
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

private const val pattern = "YYYY-mm-dd"

fun <T> lazyThreadSafetyNone(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)

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