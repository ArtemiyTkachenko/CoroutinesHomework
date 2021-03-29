package com.artkachenko.coroutineshomework.di.modules

import androidx.lifecycle.ViewModel
import com.artkachenko.coroutineshomework.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(viewModel: MainViewModel): ViewModel
}