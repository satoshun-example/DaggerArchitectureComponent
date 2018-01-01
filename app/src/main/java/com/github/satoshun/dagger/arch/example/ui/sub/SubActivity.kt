package com.github.satoshun.dagger.arch.example.ui.sub

import android.os.Bundle
import android.support.design.widget.Snackbar
import com.github.satoshun.dagger.arch.example.R
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.sub_activity.*
import javax.inject.Inject

class SubActivity : DaggerAppCompatActivity() {
  @Inject lateinit var presenter: SubActivityPresenter
  @Inject lateinit var viewModel: Lazy<SubViewModel>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.sub_activity)
    setSupportActionBar(toolbar)

    fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show()
    }

    Snackbar
        .make(fab, "${presenter.viewModel.get() == viewModel.get()}", Snackbar.LENGTH_LONG)
        .show()
  }
}
