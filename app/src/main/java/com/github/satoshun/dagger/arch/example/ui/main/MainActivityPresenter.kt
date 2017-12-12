package com.github.satoshun.dagger.arch.example.ui.main

import com.github.satoshun.dagger.arch.example.PerActivity
import dagger.Lazy
import io.reactivex.Single
import javax.inject.Inject

@PerActivity
class MainActivityPresenter @Inject constructor(
    private val viewModelStore: Lazy<MainViewModel>
) {
  private val viewModel get() = viewModelStore.get()

  fun emitTimber() {
    viewModel.data.postValue("${viewModel.number}")
  }

  fun callHoge(): Single<String> {
    return viewModel.repository.getHoge().map { it.toString() }
  }
}
