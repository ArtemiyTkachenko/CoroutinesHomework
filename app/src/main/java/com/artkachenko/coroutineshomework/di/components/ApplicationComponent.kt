package com.artkachenko.coroutineshomework.di.components

import android.app.Application
import android.content.Context
import com.artkachenko.core_api.mediator.AppProvider
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent: AppProvider {
    companion object {

        private var appComponent: AppProvider? = null

        fun create(application: Application): AppProvider {
            return appComponent ?: DaggerApplicationComponent
                .builder()
                .application(application.applicationContext)
                .build().also {
                    appComponent = it
                }
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): ApplicationComponent
    }
}