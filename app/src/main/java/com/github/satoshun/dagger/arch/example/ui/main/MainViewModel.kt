package com.github.satoshun.dagger.arch.example.ui.main

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.github.satoshun.dagger.arch.example.GitHubRepository
import javax.inject.Inject

class MainViewModel : ViewModel() {
  @SuppressLint("StaticFieldLeak")
  @Inject lateinit var app: Application
  @Inject lateinit var repository: GitHubRepository

  val data = MutableLiveData<String>()
  var number = 0
    get() {
      return field++
    }
}
