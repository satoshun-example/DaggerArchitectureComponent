package com.github.satoshun.dagger.arch.example.ui.main

import com.github.satoshun.dagger.arch.example.PerActivity
import com.github.satoshun.dagger.arch.example.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
  @PerActivity
  @ContributesAndroidInjector(modules = [MainFragmentModule::class])
  abstract fun contributeMainActivity(): MainActivity
}

@Module
abstract class MainFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
}
