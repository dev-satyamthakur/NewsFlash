package com.satyamthakur.newsflash

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsFlash : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Inside Application Class Oncreate")
    }

    companion object {
        const val TAG = "APPLOG"
    }
}