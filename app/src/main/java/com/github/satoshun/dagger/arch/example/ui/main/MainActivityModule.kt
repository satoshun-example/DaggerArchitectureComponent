package com.github.satoshun.dagger.arch.example.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.github.satoshun.dagger.arch.example.PerActivity
import com.github.satoshun.dagger.arch.example.PerFragment
import com.github.satoshun.dagger.arch.example.get
import dagger.MembersInjector
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

@Module
class MainViewModelProviderModule {
  @Provides
  fun provideViewModel(
      activity: MainActivity,
      injector: MembersInjector<MainViewModel>
  ): MainViewModel {
    return activity.provideViewModel(injector)
  }
}

inline fun <reified T : ViewModel> FragmentActivity.provideViewModel(
    injector: MembersInjector<T>
): T {
  return ViewModelProviders.of(this, ViewModelInjectorFactory(
      T::class.java::newInstance, injector
  )).get()
}

class ViewModelInjectorFactory<T : ViewModel>(
    private val newInstance: () -> T,
    private val injector: MembersInjector<T>
) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return newInstance().apply { injector.injectMembers(this) } as T
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
