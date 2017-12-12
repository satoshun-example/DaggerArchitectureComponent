package com.github.satoshun.dagger.arch.example

import io.reactivex.Single
import java.util.concurrent.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor() {
  private var number = 0
    get() {
      return field++
    }

  fun getHoge(): Single<Int> {
    return Single.just(number).delay(3, TimeUnit.SECONDS)
  }
}
