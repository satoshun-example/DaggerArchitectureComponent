package com.github.satoshun.dagger.arch.example

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v4.app.FragmentActivity
import dagger.Binds
import dagger.Module

inline fun <reified T : ViewModel> ViewModelProvider.get(): T {
  return get(T::class.java)
}

@Module
abstract class ActivityProviderModule<T : FragmentActivity> {
  @Binds
  abstract fun bindActivity(activity: T): FragmentActivity
}
