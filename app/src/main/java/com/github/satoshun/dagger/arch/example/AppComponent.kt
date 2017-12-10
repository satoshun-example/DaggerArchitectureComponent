package com.github.satoshun.dagger.arch.example

import com.github.satoshun.dagger.arch.example.ui.main.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
AndroidSupportInjectionModule::class,
MainActivityModule::class
])
interface AppComponent : AndroidInjector<App>
