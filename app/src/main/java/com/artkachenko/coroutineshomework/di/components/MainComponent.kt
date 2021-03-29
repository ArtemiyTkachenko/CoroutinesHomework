package com.artkachenko.coroutineshomework.di.components

import com.artkachenko.coroutineshomework.MovieApp
import com.artkachenko.coroutineshomework.di.modules.MainModule
import com.artkachenko.coroutineshomework.ui.main.MainFragment
import dagger.Component
import java.lang.annotation.Documented
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScope

@MainScope
@Component(
    modules = [MainModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainComponent {
    fun inject(fragment: MainFragment)

    companion object {

        fun create(appComponent: ApplicationComponent): MainComponent {
            return DaggerMainComponent.builder()
                .applicationComponent(appComponent)
                .build()
        }

        fun injectFragment(fragment: MainFragment): MainComponent  {
            val component = create(MovieApp.getApplicationComponent())
            component.inject(fragment)
            return component
        }
    }
}