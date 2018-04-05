package com.github.satoshun.dagger.arch.example.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.github.satoshun.dagger.arch.example.R
import com.github.satoshun.io.reactivex.lifecycleowner.subscribeOf
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    HasSupportFragmentInjector {

  @Inject lateinit var presenter: MainActivityPresenter
  @Inject lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    Observable.interval(1, TimeUnit.SECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOf(this, onNext = { presenter.emitTimber() })

    presenter.callHoge().observeOn(AndroidSchedulers.mainThread())
        .subscribeOf(this, onSuccess = {
          Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
  }

  override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjector
}
