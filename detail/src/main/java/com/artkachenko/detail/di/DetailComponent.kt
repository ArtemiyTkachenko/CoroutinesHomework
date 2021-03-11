package com.artkachenko.detail.di

import com.artkachenko.core.CoreProvidersFactory
import com.artkachenko.core_api.mediator.AppWithFacade
import com.artkachenko.core_api.mediator.ProvidersFacade
import com.artkachenko.core_api.viewmodel.ViewModelsProvider
import com.artkachenko.detail.ui.DetailFragment
import dagger.Component
import java.lang.annotation.Documented
import javax.inject.Scope

@Scope
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class DetailScope

@DetailScope
@Component(
    dependencies = [ProvidersFacade::class, ViewModelsProvider::class],
    modules = [DetailModule::class]
)
interface DetailComponent {
    fun inject(fragment: DetailFragment)

    companion object {

        fun create(providersFacade: ProvidersFacade): DetailComponent {
            return DaggerDetailComponent
                .builder()
                .viewModelsProvider(CoreProvidersFactory.createViewModelBuilder())
                .providersFacade(providersFacade)
                .build()
        }

        fun injectFragment(fragment: DetailFragment): DetailComponent  {
            val facade = (fragment.activity?.application as AppWithFacade).getFacade()
            val component = create(facade)
            component.inject(fragment)
            return component
        }
    }
}