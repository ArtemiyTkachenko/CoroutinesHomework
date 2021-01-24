package com.artkachenko.coroutineshomework.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    protected val scope = CoroutineScope(SupervisorJob() + coroutineContext + exceptionHandler)
}