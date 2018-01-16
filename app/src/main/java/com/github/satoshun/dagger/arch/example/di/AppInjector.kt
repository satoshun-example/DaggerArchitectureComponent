package com.github.satoshun.dagger.arch.example.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.github.satoshun.dagger.arch.example.App
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import java.util.concurrent.atomic.*

fun App.applyInjector() {
  registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
      handleActivity(activity)
    }
  })
}

private fun handleActivity(activity: Activity) {
  val flag = AtomicBoolean(true)
  (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
      object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentCreated(
            fm: FragmentManager?,
            f: Fragment?,
            savedInstanceState: Bundle?
        ) {
          // inject only once
          if (flag.getAndSet(false) && activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
          }
          if (f is Injectable) {
            AndroidSupportInjection.inject(f)
          }
        }
      }, true)
}
