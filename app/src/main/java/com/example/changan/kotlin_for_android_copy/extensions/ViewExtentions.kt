package com.example.changan.kotlin_for_android_copy.extensions

import android.content.Context
import android.view.View

/**
 * 这个文件用来对View相关属性进行扩展
 */

/**
 * 对View扩展ctx属性，简化getContext()
 */
val View.ctx: Context
    get() = context