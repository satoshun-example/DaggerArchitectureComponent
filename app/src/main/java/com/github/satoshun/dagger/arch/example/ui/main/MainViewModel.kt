package com.github.satoshun.dagger.arch.example.ui.main

import android.app.Application
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel : ViewModel() {
  @Inject lateinit var app: Application
}
