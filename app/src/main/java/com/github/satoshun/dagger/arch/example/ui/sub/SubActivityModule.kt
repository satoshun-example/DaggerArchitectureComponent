package com.github.satoshun.dagger.arch.example.ui.sub

import com.github.satoshun.dagger.arch.example.di.ActivityProviderModule
import com.github.satoshun.dagger.arch.example.di.PerActivity
import com.github.satoshun.dagger.arch.example.di.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SubActivityModule {
  @PerActivity
  @ContributesAndroidInjector(modules = [
    SubActivityProviderModule::class,
    SubFragmentModule::class
  ])
  abstract fun contributeSubActivity(): SubActivity
}

@Module
class SubActivityProviderModule : ActivityProviderModule<SubActivity, SubViewModel>(
    SubViewModel::class.java
)

@Module
abstract class SubFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeSubFragment(): SubFragment
}
