package com.artkachenko.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale

fun ImageView.loadImage(url: String, @DrawableRes placeholderRes: Int, shouldCrossfade: Boolean = true, scaleType: Scale = Scale.FIT) {
    val actualUrl = "http://image.tmdb.org/t/p/w500$url"

    debugLog("actualUrl is $actualUrl")

    this.load(actualUrl) {
        crossfade(shouldCrossfade)
        placeholder(placeholderRes)
        scale(scaleType)
    }
}

fun View.setSingleClickListener(waitMillis: Long = 1000, listener: () -> Unit) {
    var lastClickTime = 0L
    setOnClickListener { view ->
        if (System.currentTimeMillis() > lastClickTime + waitMillis) {
            listener.invoke()
            lastClickTime = System.currentTimeMillis()
        }
    }
}

fun Any.debugLog(message: String, tag: String? = null) {
    if (BuildConfig.DEBUG) {
        val actualTag = tag ?: javaClass.simpleName
        Log.d(actualTag, message)
    }
}

fun RecyclerView.onLoadMore(threshold: Int = 10, loadMore: () -> Unit) {
    val layoutManager = this.layoutManager as GridLayoutManager
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(
            recyclerView: RecyclerView,
            dx: Int, dy: Int
        ) {
            super.onScrolled(recyclerView, dx, dy)
            val totalItemCount = layoutManager.itemCount
            val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
            if (totalItemCount <= lastVisibleItem + threshold) {
                loadMore()
            }
        }
    })
}