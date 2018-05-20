package com.kevinabrioux.mvvmimplementation.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.kevinabrioux.mvvmimplementation.manager.LightManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * Created by kevinabrioux on 26/01/2018.
 */
class MainViewModel : ViewModel() {

    val lightValue = ObservableField<String>()
    private val disposables = CompositeDisposable()

    fun bind(lightManager: LightManager?) {
        lightManager?.lightValue
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.newThread())
                ?.subscribe { lightValue.set(it.toString()) }
                ?.let { disposables.add(it) }
    }
}