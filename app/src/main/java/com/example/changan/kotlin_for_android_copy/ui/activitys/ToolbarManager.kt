package com.example.changan.kotlin_for_android_copy.ui.activitys

import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.changan.kotlin_for_android_copy.R

interface ToolbarManager {
    val toolbar : Toolbar

    /**
     * kotlin中通过缩进实现set 和 get 方法
     */
    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }


}