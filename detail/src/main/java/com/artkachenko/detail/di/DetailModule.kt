package com.artkachenko.detail.di

import androidx.lifecycle.ViewModel
import com.artkachenko.core_api.network.DetailNetworkRepository
import com.artkachenko.detail.network.DetailNetworkRepositoryImpl
import com.artkachenko.detail.ui.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DetailModule {

    companion object {

        @Provides
        @DetailScope
        @JvmStatic
        fun provideMainViewModel(
            map: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>,
            repositoryImpl: DetailNetworkRepositoryImpl
        ): ViewModel = DetailViewModel(repositoryImpl).also {
            map[DetailViewModel::class.java] = it
        }

        @Provides
        @DetailScope
        @JvmStatic
        fun provideDummy(viewModel: ViewModel) = EagerTrigger()
    }
}

class EagerTrigger