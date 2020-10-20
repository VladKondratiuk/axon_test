package com.example.axon_test.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

inline fun <reified T> Observable<T>.composeExecutionThreads(
    observeOn: Scheduler = AndroidSchedulers.mainThread(),
    subscribeOn: Scheduler = Schedulers.computation()
): Observable<T> = observeOn(observeOn)
    .subscribeOn(subscribeOn)

fun <T> lazyThreadSafetyNone(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)
