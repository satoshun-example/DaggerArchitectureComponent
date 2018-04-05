package com.github.satoshun.dagger.arch.example.ui.main

import android.support.v7.app.AppCompatActivity
import com.github.satoshun.dagger.arch.example.di.PerActivity
import com.github.satoshun.dagger.arch.example.di.PerFragment
import com.github.satoshun.dagger.arch.example.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityBuilder {
  @PerActivity
  @ContributesAndroidInjector(modules = [
    MainActivityModule::class,
    MainViewModelModule::class,
    MainFragmentModule::class
  ])
  fun contributeMainActivity(): MainActivity
}

@Module
interface MainActivityModule {
  @Binds
  fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
}

@Module
class MainViewModelModule : ViewModelModule<MainViewModel>(MainViewModel::class.java)

@Module
interface MainFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  fun contributeMainFragment(): MainFragment
}
