package com.github.satoshun.dagger.arch.example.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityProviderModule<in T : FragmentActivity, VM : ViewModel>(
    private val kclass: Class<VM>
) {
  @Provides
  fun providedActivity(activity: T): FragmentActivity = activity

  @Provides
  fun provideClass(): Class<VM> = kclass

  @Provides
  fun provideViewModel(
      activity: FragmentActivity,
      kclass: Class<VM>,
      factory: ViewModelInjectorFactory<VM>
  ): VM {
    return ViewModelProviders.of(activity, factory).get(kclass)
  }
}
