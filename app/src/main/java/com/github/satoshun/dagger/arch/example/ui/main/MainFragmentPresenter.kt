package com.github.satoshun.dagger.arch.example.ui.main

import android.arch.lifecycle.LiveData
import com.github.satoshun.dagger.arch.example.PerFragment
import javax.inject.Inject

@PerFragment
class MainFragmentPresenter @Inject constructor(
    private val viewModel: MainViewModel
) {
  val live: LiveData<String> get() = viewModel.data
}
