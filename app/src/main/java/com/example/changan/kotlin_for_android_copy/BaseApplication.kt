package com.example.changan.kotlin_for_android_copy

import android.app.Application

class BaseApplication : Application(){

    companion object {
        var instances: BaseApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instances = this
    }
}