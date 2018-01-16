package com.github.satoshun.dagger.arch.example

import com.github.satoshun.dagger.arch.example.di.applyInjector
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
  override fun onCreate() {
    super.onCreate()
    applyInjector()
  }

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
  }
}
