package com.example.changan.kotlin_for_android_copy

import android.util.Log
import java.net.URL

class Request(val url: String) {
    public fun run() {
        val forecastJsonStr = URL(url).readText()
    }
}