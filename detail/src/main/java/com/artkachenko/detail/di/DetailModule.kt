package com.artkachenko.detail.di

import androidx.lifecycle.ViewModel
import com.artkachenko.core_api.network.DetailNetworkRepository
import com.artkachenko.core_api.network.MainNetworkRepository
import com.artkachenko.detail.network.DetailNetworkRepositoryImpl
import com.artkachenko.detail.ui.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DetailModule {

    @Binds
    @Singleton
    abstract fun bindsCache(repositoryImpl: DetailNetworkRepositoryImpl): DetailNetworkRepository

    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideMainViewModel(
            map: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>,
            repositoryImpl: DetailNetworkRepositoryImpl
        ): ViewModel = DetailViewModel(repositoryImpl).also {
            map[DetailViewModel::class.java] = it
        }
    }
}