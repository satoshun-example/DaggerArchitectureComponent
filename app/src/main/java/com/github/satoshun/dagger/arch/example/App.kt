package com.github.satoshun.dagger.arch.example

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
  }
}
