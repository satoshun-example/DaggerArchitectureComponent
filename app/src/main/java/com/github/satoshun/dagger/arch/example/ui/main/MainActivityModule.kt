package com.github.satoshun.dagger.arch.example.ui.main

import com.github.satoshun.dagger.arch.example.ActivityProviderModule
import com.github.satoshun.dagger.arch.example.PerActivity
import com.github.satoshun.dagger.arch.example.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
  @PerActivity
  @ContributesAndroidInjector(modules = [
    MainActivityProviderModule::class,
    MainFragmentModule::class
  ])
  abstract fun contributeMainActivity(): MainActivity
}

@Module
class MainActivityProviderModule : ActivityProviderModule<MainActivity, MainViewModel>(
    MainViewModel::class.java
)

@Module
abstract class MainFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
}
