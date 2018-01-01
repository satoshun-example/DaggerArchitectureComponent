package com.github.satoshun.dagger.arch.example.ui.sub

import com.github.satoshun.dagger.arch.example.*
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class SubActivityModule {
  @PerActivity
  @ContributesAndroidInjector(modules = [
    SubViewModelProviderModule::class,
    SubFragmentModule::class
  ])
  abstract fun contributeSubActivity(): SubActivity
}

@Module(includes = [SubActivityProviderModule::class])
class SubViewModelProviderModule {
  @Provides
  fun provideViewModel(creator: ViewModelCreator<SubViewModel>): SubViewModel {
    return creator().get()
  }
}


@Module
abstract class SubActivityProviderModule : ActivityProviderModule<SubActivity>()

@Module
abstract class SubFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeSubFragment(): SubFragment
}
