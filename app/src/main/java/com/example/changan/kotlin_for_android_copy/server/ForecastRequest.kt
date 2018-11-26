package com.example.changan.kotlin_for_android_copy.server

import com.google.gson.Gson


class ForecastRequest(val zipCity: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {

        val forecastResultStr = java.net.URL(COMPLETE_URL + zipCity).readText()
        return Gson().fromJson(forecastResultStr, ForecastResult::class.java)
    }
}