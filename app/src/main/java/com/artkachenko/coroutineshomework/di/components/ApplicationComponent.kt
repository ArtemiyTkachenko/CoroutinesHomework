package com.artkachenko.coroutineshomework.di.components

import com.artkachenko.coroutineshomework.MovieApp
import com.artkachenko.coroutineshomework.di.modules.NetworkModule
import com.artkachenko.coroutineshomework.di.modules.UIModule
import com.artkachenko.coroutineshomework.di.modules.ViewModelModule
import com.artkachenko.coroutineshomework.ui.detail.DetailFragment
import com.artkachenko.coroutineshomework.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, NetworkModule::class, ViewModelModule::class, UIModule::class])
interface ApplicationComponent {
    fun inject(app: MovieApp)
    fun inject(mainFragment: MainFragment)
    fun inject(detailFragment: DetailFragment)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: MovieApp): Builder

        fun build(): ApplicationComponent
    }
}