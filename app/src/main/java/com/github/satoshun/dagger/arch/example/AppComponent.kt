package com.github.satoshun.dagger.arch.example

import android.app.Application
import android.arch.lifecycle.ViewModel
import com.github.satoshun.dagger.arch.example.ui.main.MainActivityModule
import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
@Component(modules = [
  AndroidSupportInjectionModule::class,
  AppModule::class,
  MainActivityModule::class
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


//class ViewModelFactory @Inject constructor(
//    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards MembersInjector<ViewModel>>
//) : ViewModelProvider.Factory {
//  override fun <T : ViewModel> create(modelClass: Class<T>): T {
//    val creator = creators[modelClass] as? MembersInjector<T>
//        ?: throw IllegalArgumentException("unknown model class " + modelClass)
//    try {
//      return modelClass.newInstance().apply { creator.injectMembers(this) }
//    } catch (e: Exception) {
//      throw RuntimeException(e)
//    }
//  }
//}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(
    val value: KClass<out ViewModel>
)
