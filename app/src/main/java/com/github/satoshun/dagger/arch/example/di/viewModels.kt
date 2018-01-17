package com.github.satoshun.dagger.arch.example.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import dagger.MembersInjector
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
abstract class ViewModelModule<VM : ViewModel>(
    private val kclass: Class<VM>
) {
  @Provides
  fun provideViewModel(
      activity: AppCompatActivity,
      factory: ViewModelInjectorFactory<VM>
  ): VM {
    return ViewModelProviders.of(activity, factory).get(kclass)
  }
}

class ViewModelInjectorFactory<T : ViewModel> @Inject constructor(
    private val injector: MembersInjector<T>
) : ViewModelProvider.Factory {
  override fun <V : ViewModel> create(modelClass: Class<V>): V {
    return modelClass.newInstance().apply { injector.injectMembers(this as T) }
  }
}
