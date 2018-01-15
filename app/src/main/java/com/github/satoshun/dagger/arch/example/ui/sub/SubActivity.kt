package com.github.satoshun.dagger.arch.example.ui.sub

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.github.satoshun.dagger.arch.example.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.sub_activity.*
import javax.inject.Inject

class SubActivity : AppCompatActivity(),
    HasSupportFragmentInjector {

  @Inject lateinit var presenter: SubActivityPresenter
  @Inject lateinit var viewModel: SubViewModel
  @Inject lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.sub_activity)
    setSupportActionBar(toolbar)

    fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show()
    }

    Snackbar
        .make(fab, "${presenter.viewModel == viewModel}", Snackbar.LENGTH_LONG)
        .show()
  }

  override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjector
}
