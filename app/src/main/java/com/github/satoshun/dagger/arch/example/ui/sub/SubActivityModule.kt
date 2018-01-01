package com.github.satoshun.dagger.arch.example.ui.sub

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
abstract class SubActivityProviderModule {
  @Binds
  abstract fun bindActivity(activity: SubActivity): FragmentActivity
}

@Module
abstract class SubFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeSubFragment(): SubFragment
}
