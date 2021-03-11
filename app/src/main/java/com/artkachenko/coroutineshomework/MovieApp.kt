package com.artkachenko.coroutineshomework

import androidx.multidex.MultiDexApplication
import com.artkachenko.core_api.mediator.AppWithFacade
import com.artkachenko.core_api.mediator.ProvidersFacade
import com.artkachenko.coroutineshomework.di.components.FacadeComponent

class MovieApp : MultiDexApplication(), AppWithFacade {
    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }


    companion object {

        private var facadeComponent: FacadeComponent? = null
    }
}