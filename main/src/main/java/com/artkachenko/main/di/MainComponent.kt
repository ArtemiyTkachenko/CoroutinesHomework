package com.artkachenko.main.di

import com.artkachenko.core.CoreProvidersFactory
import com.artkachenko.core_api.mediator.AppWithFacade
import com.artkachenko.core_api.mediator.ProvidersFacade
import com.artkachenko.core_api.viewmodel.ViewModelsProvider
import com.artkachenko.main.ui.MainFragment
import dagger.Component
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScope

@MainScope
@Component(
    modules = [MainModule::class],
    dependencies = [ProvidersFacade::class, ViewModelsProvider::class]
)
interface MainComponent : ViewModelsProvider {
    fun inject(fragment: MainFragment)

    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent
                .builder()
                .viewModelsProvider(CoreProvidersFactory.createViewModelBuilder())
                .providersFacade(providersFacade)
                .build()
        }

        fun injectFragment(fragment: MainFragment): MainComponent  {
            val facade = (fragment.activity?.application as AppWithFacade).getFacade()
            val component = create(facade)
            component.inject(fragment)
            return component
        }
    }
}