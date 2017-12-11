package com.github.satoshun.dagger.arch.example.ui.main

import android.os.Bundle
import com.github.satoshun.dagger.arch.example.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
  @Inject lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)
  }
}
