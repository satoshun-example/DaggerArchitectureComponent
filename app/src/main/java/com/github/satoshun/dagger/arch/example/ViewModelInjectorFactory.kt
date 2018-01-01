package com.github.satoshun.dagger.arch.example

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.MembersInjector
import javax.inject.Inject

class ViewModelInjectorFactory<T : ViewModel> @Inject constructor(
    private val injector: MembersInjector<T>
) : ViewModelProvider.Factory {
  override fun <V : ViewModel> create(modelClass: Class<V>): V {
    return modelClass.newInstance().apply { injector.injectMembers(this as T) }
  }
}
