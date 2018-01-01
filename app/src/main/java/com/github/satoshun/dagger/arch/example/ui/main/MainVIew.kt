package com.github.satoshun.dagger.arch.example.ui.main

import android.content.Context
import android.view.View
import com.github.satoshun.dagger.arch.example.GitHubRepository
import javax.inject.Inject

class MainView(context: Context) : View(context) {
  @Inject lateinit var repository: GitHubRepository
  @Inject lateinit var viewModel: MainViewModel
}
