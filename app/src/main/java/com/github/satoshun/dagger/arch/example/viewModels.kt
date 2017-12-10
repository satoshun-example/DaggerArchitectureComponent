package com.github.satoshun.dagger.arch.example

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> ViewModelProvider.get(): T {
  return get(T::class.java)
}
