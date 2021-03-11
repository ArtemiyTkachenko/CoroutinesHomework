package com.artkachenko.core

import com.artkachenko.core_api.mediator.AppProvider
import com.artkachenko.core_api.network.NetworkProvider
import com.artkachenko.core_api.viewmodel.ViewModelsProvider
import com.artkachenko.core_impl.DaggerNetworkComponent
import com.artkachenko.core_impl.DaggerViewModelComponent

object CoreProvidersFactory {

    fun createNetworkBuilder(appProvider: AppProvider): NetworkProvider? {
        return DaggerNetworkComponent.builder().appProvider(appProvider).build()
    }

    fun createViewModelBuilder(): ViewModelsProvider {
        return DaggerViewModelComponent.builder().build()
    }
}