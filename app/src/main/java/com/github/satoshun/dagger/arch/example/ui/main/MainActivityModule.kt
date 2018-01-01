package com.github.satoshun.dagger.arch.example.ui.main

import com.github.satoshun.dagger.arch.example.*
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
  @PerActivity
  @ContributesAndroidInjector(modules = [
    MainViewModelProviderModule::class,
    MainFragmentModule::class
  ])
  abstract fun contributeMainActivity(): MainActivity
}

@Module(includes = [MainActivityProviderModule::class])
class MainViewModelProviderModule {
  @Provides
  fun provideViewModel(creator: ViewModelCreator<MainViewModel>): MainViewModel {
    return creator().get()
  }
}

@Module
abstract class MainActivityProviderModule : ActivityProviderModule<MainActivity>()

@Module
abstract class MainFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
}
