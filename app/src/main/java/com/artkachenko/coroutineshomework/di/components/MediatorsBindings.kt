package com.artkachenko.coroutineshomework.di.components

import com.artkachenko.core_api.mediator.DetailMediator
import com.artkachenko.core_api.mediator.MainMediator
import com.artkachenko.detail.navigation.DetailMediatorImpl
import com.artkachenko.main.navigation.MainMediatorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface MediatorsBindings {

    @Binds
    @Reusable
    fun bindsMainMediator(mainMediatorImpl: MainMediatorImpl): MainMediator

    @Binds
    @Reusable
    fun bindsHomeMediator(homeMediatorImpl: DetailMediatorImpl): DetailMediator
}