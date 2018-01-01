# Dagger2 sample with Android Architecture Components

## features
- `ViewModel` is injected from `Provider`, So `ViewModel` can be inject to other classes based on Dagger injection tree. 
    - [sample](app/src/main/java/com/github/satoshun/dagger/arch/example/ui/main/MainActivityModule.kt)
- use Android Dagger module
- use Kotlin


## sample code

it's sample code for MainActivity and MainViewModel.

```kotlin
@Module
abstract class MainActivityModule {
  @PerActivity
  @ContributesAndroidInjector(modules = [
    MainActivityProviderModule::class,
    MainFragmentModule::class
  ])
  abstract fun contributeMainActivity(): MainActivity
}

@Module
class MainActivityProviderModule : ActivityProviderModule<MainActivity, MainViewModel>(
    MainViewModel::class.java
)

@Module
abstract class MainFragmentModule {
  @PerFragment
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
}
```
