package com.artkachenko.core_impl

import com.artkachenko.core_api.mediator.AppProvider
import com.artkachenko.core_api.network.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent: NetworkProvider