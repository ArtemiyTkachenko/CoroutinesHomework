package com.artkachenko.main.di

import androidx.lifecycle.ViewModel
import com.artkachenko.core_api.network.MainNetworkRepository
import com.artkachenko.main.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import com.artkachenko.main.network.MainNetworkRepositoryImpl
import javax.inject.Singleton

@Module
abstract class MainModule {

    @Binds
    @Singleton
    abstract fun bindsCache(repositoryImpl: MainNetworkRepositoryImpl): MainNetworkRepository

    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideMainViewModel(
            map: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>,
            repositoryImpl: MainNetworkRepositoryImpl
        ): ViewModel = MainViewModel(repositoryImpl).also {
            map[MainViewModel::class.java] = it
        }
    }
}