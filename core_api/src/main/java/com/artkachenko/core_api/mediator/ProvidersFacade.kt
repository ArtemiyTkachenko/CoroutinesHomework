package com.artkachenko.core_api.mediator

import com.artkachenko.core_api.network.NetworkProvider

interface ProvidersFacade : MediatorsProvider, NetworkProvider, AppProvider {
}