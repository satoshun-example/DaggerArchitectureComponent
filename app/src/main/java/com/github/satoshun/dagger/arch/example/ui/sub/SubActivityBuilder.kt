package com.github.satoshun.dagger.arch.example.ui.sub

import android.support.v7.app.AppCompatActivity
import com.github.satoshun.dagger.arch.example.di.PerActivity
import com.github.satoshun.dagger.arch.example.di.PerFragment
import com.github.satoshun.dagger.arch.example.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SubActivityBuilder {
  @PerActivity
  @ContributesAndroidInjector(modules = [
    SubActivityModule::class,
    SubViewModelModule::class,
    SubFragmentModule::class
  ])
  fun contributeSubActivity(): SubActivity
}

@Module
interface SubActivityModule {
  @Binds
  fun providesAppCompatActivity(mainActivity: SubActivity): AppCompatActivity
}

@Module
class SubViewModelModule : ViewModelModule<SubViewModel>(SubViewModel::class.java)

@Module
interface SubFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  fun contributeSubFragment(): SubFragment
}
