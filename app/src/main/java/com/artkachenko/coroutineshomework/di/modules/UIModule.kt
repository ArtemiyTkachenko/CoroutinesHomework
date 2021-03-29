package com.artkachenko.coroutineshomework.di.modules

import com.artkachenko.coroutineshomework.MainActivity
import com.artkachenko.coroutineshomework.ui.detail.DetailFragment
import com.artkachenko.coroutineshomework.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UIModule {
    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributesMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailFragment(): DetailFragment
}