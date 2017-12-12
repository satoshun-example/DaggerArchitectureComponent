package com.github.satoshun.dagger.arch.example.ui.main

import android.os.Bundle
import android.widget.Toast
import com.github.satoshun.dagger.arch.example.R
import com.github.satoshun.io.reactivex.lifecycleowner.subscribeOf
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
  @Inject lateinit var presenter: MainActivityPresenter

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
}
