package com.github.satoshun.dagger.arch.example.ui.sub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.satoshun.dagger.arch.example.Injectable
import com.github.satoshun.dagger.arch.example.R

class SubFragment : Fragment(), Injectable {
  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.fragment_sub, container, false)
  }
}
