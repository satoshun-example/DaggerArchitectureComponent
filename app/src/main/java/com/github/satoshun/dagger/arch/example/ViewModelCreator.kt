package com.github.satoshun.dagger.arch.example

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import javax.inject.Inject

class ViewModelCreator<T : ViewModel> @Inject constructor(
    private val activity: FragmentActivity,
    private val factory: ViewModelInjectorFactory<T>
) {
  operator fun invoke(): ViewModelProvider {
    return ViewModelProviders.of(activity, factory)
  }
}
