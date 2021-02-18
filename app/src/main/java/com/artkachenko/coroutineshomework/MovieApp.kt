package com.artkachenko.coroutineshomework

import android.app.Application
import android.content.Context
import android.os.StrictMode
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import com.artkachenko.coroutineshomework.di.components.ApplicationComponent
import com.artkachenko.coroutineshomework.di.components.DaggerApplicationComponent
import com.artkachenko.coroutineshomework.utils.debugLog
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MovieApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
        }
    }

    private fun initDagger() {
        applicationComponent = DaggerApplicationComponent.builder().app(this).build()
        applicationComponent.inject(this)
    }

    companion object {

        private lateinit var applicationComponent : ApplicationComponent

        fun getApplicationComponent() : ApplicationComponent {
            return applicationComponent
        }
    }
}