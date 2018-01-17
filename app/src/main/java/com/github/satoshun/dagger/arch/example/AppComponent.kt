package com.github.satoshun.dagger.arch.example

import android.app.Application
import com.github.satoshun.dagger.arch.example.ui.main.MainActivityBuilder
import com.github.satoshun.dagger.arch.example.ui.sub.SubActivityBuilder
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidSupportInjectionModule::class,
  AppModule::class,
  MainActivityBuilder::class,
  SubActivityBuilder::class
])
interface AppComponent : AndroidInjector<App>


@Module
class AppModule(private val app: App) {
  @Singleton
  @Provides
  fun provideApplication(): Application {
    return app
  }
}
