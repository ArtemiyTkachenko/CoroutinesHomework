package com.artkachenko.coroutineshomework.di.components

import com.artkachenko.coroutineshomework.MovieApp
import com.artkachenko.coroutineshomework.di.modules.DetailModule
import com.artkachenko.coroutineshomework.ui.detail.DetailFragment
import dagger.Component
import java.lang.annotation.Documented
import javax.inject.Scope

@Scope
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class DetailScope

@DetailScope
@Component(
    modules = [DetailModule::class],
    dependencies = [ApplicationComponent::class]
)
interface DetailComponent {
    fun inject(fragment: DetailFragment)

    companion object {

        fun create(appComponent: ApplicationComponent): DetailComponent {
            return DaggerDetailComponent.builder()
                .applicationComponent(appComponent)
                .build()
        }

        fun injectFragment(fragment: DetailFragment): DetailComponent  {
            val component = create(MovieApp.getApplicationComponent())
            component.inject(fragment)
            return component
        }
    }
}