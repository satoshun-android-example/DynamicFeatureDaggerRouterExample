package com.github.satoshun.example.feature.sub1

import android.app.Activity
import com.github.satoshun.example.CoreComponent
import com.github.satoshun.example.feature.main.RouterBuilder
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  dependencies = [CoreComponent::class],
  modules = [
    AndroidSupportInjectionModule::class,
    Sub1Builder::class,
    RouterBuilder::class
  ]
)
internal interface Sub1Component : AndroidInjector<Sub1Activity> {
  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<Sub1Activity>() {
    abstract fun appComponent(module: CoreComponent): Builder
  }

  val dispatching: DispatchingAndroidInjector<Activity>
}


@Module(
  includes = [Sub1ActivityModule::class]
)
interface Sub1Builder

@Module
internal interface Sub1ActivityModule {
  @ContributesAndroidInjector fun contributeSub1Activity(): Sub1Activity
}
