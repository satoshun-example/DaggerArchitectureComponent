package com.github.satoshun.dagger.arch.example

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides

inline fun <reified T : ViewModel> ViewModelProvider.get(): T {
  return get(T::class.java)
}

@Module
abstract class ActivityProviderModule<in T : FragmentActivity, VM : ViewModel>(
    private val kclass: Class<VM>
) {
  @Provides
  fun providedActivity(activity: T): FragmentActivity = activity

  @Provides
  fun provideViewModel(creator: ViewModelCreator<VM>): VM = creator()

  @Provides
  fun provideClass(): Class<VM> = kclass
}
