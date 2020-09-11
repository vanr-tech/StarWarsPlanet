package com.vanr.starwarsplanet.base.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

open class BaseViewModel: ViewModel() {
    val compositeDisposable = CompositeDisposable()

    protected open fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    protected open fun addDisposables(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    fun handleError(error: Throwable) {
        Timber.e(error)
    }
}