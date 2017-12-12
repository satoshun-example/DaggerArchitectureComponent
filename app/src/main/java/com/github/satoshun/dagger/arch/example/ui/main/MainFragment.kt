package com.github.satoshun.dagger.arch.example.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.github.satoshun.dagger.arch.example.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {
  @Inject lateinit var presenter: MainFragmentPresenter

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.main_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    presenter.live.observe(this, Observer { str ->
      (view as LinearLayout).addView(
          TextView(view.context).apply {
            text = str!!
          }
      )
    })
  }
}
