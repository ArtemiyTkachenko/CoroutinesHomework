package com.artkachenko.coroutineshomework.di.components

import android.app.Application
import com.artkachenko.core.CoreProvidersFactory
import com.artkachenko.core_api.mediator.AppProvider
import com.artkachenko.core_api.mediator.ProvidersFacade
import com.artkachenko.core_api.network.NetworkProvider
import com.artkachenko.coroutineshomework.MovieApp
import dagger.Component

@Component(
    dependencies = [AppProvider::class, NetworkProvider::class],
    modules = [MediatorsBindings::class]
)
interface FacadeComponent : ProvidersFacade {

    companion object {

        fun init(application: Application): FacadeComponent {
            val appProvider = ApplicationComponent.create(application)
            return DaggerFacadeComponent.builder()
                .appProvider(appProvider)
                .networkProvider(CoreProvidersFactory.createNetworkBuilder(appProvider))
                .build()
        }
    }

    fun inject(app: MovieApp)
}