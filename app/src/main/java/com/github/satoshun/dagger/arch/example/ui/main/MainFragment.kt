package com.github.satoshun.dagger.arch.example.ui.main

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.github.satoshun.dagger.arch.example.di.Injectable
import com.github.satoshun.dagger.arch.example.R
import com.github.satoshun.dagger.arch.example.ui.sub.SubActivity
import kotlinx.android.synthetic.main.main_frag.*
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {
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
          TextView(view.context).apply { text = str!! }
      )
    })
    new_activity.setOnClickListener {
      startActivity(Intent(activity, SubActivity::class.java))
    }
  }
}
