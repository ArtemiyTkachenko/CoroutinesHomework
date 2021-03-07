package com.artkachenko.coroutineshomework.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artkachenko.coroutineshomework.di.modules.DaggerViewModelFactory
import com.artkachenko.coroutineshomework.ui.detail.DetailViewModel
import com.artkachenko.coroutineshomework.ui.main.MainViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Reusable
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module(includes = [MainModule::class, DetailModule::class])
interface ViewModelModule {
    @Binds
    @Reusable
    fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}