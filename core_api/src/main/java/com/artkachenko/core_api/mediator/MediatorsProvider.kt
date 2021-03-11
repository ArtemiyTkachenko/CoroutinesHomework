package com.artkachenko.core_api.mediator

interface MediatorsProvider {

    fun provideMainMediator(): MainMediator

    fun provideDetailMediator(): DetailMediator
}