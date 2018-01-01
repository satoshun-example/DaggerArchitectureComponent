package com.github.satoshun.dagger.arch.example.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.github.satoshun.dagger.arch.example.PerActivity
import com.github.satoshun.dagger.arch.example.PerFragment
import com.github.satoshun.dagger.arch.example.get
import dagger.Binds
import dagger.MembersInjector
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject

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

class ViewModelCreator<T : ViewModel> @Inject constructor(
    private val activity: FragmentActivity,
    private val factory: ViewModelInjectorFactory<T>
) {
  operator fun invoke(): ViewModelProvider {
    return ViewModelProviders.of(activity, factory)
  }
}

class ViewModelInjectorFactory<T : ViewModel> @Inject constructor(
    private val injector: MembersInjector<T>
) : ViewModelProvider.Factory {
  override fun <V : ViewModel> create(modelClass: Class<V>): V {
    return modelClass.newInstance().apply { injector.injectMembers(this as T) }
  }
}

//@Module
// abstract class ViewModelModule {
//  @Binds
//  @IntoMap
//  @ViewModelKey(MainViewModel::class)
//  abstract fun bindUserViewModel(viewModel: MainViewModel): ViewModel
//
//  @Binds
//  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
//}

@Module
abstract class MainFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
}
