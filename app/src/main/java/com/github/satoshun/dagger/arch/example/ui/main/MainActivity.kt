package com.github.satoshun.dagger.arch.example.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.github.satoshun.dagger.arch.example.R
import com.github.satoshun.dagger.arch.example.get
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    viewModel = ViewModelProviders.of(this).get()
  }
}
