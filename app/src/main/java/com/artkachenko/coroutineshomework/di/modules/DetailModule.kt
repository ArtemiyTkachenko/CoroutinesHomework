package com.artkachenko.coroutineshomework.di.modules

import androidx.lifecycle.ViewModel
import com.artkachenko.coroutineshomework.ui.detail.DetailViewModel
import com.artkachenko.coroutineshomework.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun detailViewModel(viewModel: DetailViewModel): ViewModel
}