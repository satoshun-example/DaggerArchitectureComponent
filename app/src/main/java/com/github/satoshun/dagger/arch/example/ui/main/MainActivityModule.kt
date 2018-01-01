package com.github.satoshun.dagger.arch.example.ui.main

import android.support.v4.app.FragmentActivity
import com.github.satoshun.dagger.arch.example.PerActivity
import com.github.satoshun.dagger.arch.example.PerFragment
import com.github.satoshun.dagger.arch.example.ViewModelCreator
import com.github.satoshun.dagger.arch.example.get
import dagger.Binds
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
abstract class MainActivityProviderModule {
  @Binds
  abstract fun bindActivity(activity: MainActivity): FragmentActivity
}

@Module
abstract class MainFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
}
