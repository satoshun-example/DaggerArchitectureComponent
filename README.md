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
```
