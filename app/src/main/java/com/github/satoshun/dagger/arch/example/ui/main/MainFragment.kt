package com.github.satoshun.dagger.arch.example.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.satoshun.dagger.arch.example.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {
  @Inject lateinit var viewModel: MainViewModel

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.main_frag, container, false)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}
