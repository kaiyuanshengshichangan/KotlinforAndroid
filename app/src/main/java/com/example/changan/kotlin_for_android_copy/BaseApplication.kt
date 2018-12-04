package com.example.changan.kotlin_for_android_copy

import android.app.Application
import com.example.changan.kotlin_for_android_copy.extensions.DelegateExt
import kotlin.properties.Delegates

class BaseApplication : Application(){

//    companion object {
//        var instances: BaseApplication? = null
//    }
    companion object {
        var instances : BaseApplication by DelegateExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instances = this
    }
}