package com.github.satoshun.dagger.arch.example.ui.sub

import com.github.satoshun.dagger.arch.example.PerActivity
import dagger.Lazy
import javax.inject.Inject

@PerActivity
class SubActivityPresenter @Inject constructor(
    val viewModel: Lazy<SubViewModel>
)
