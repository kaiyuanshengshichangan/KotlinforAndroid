package com.example.changan.kotlin_for_android_copy.ui.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.changan.kotlin_for_android_copy.R
import com.example.changan.kotlin_for_android_copy.Request
import com.example.changan.kotlin_for_android_copy.domain.commands.RequestForecastCommand
import com.example.changan.kotlin_for_android_copy.ui.activitys.adapter.WeatherListAdatper
import kotlinx.android.synthetic.main.activity_weather_list.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 * 天气列表
 */
class WeatherListActivity : AppCompatActivity() {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
        "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    private val items = listOf(
        "Mon 6/13 - Sunny - 31/17",
        "Tue 6/14 - Foggy - 31/17",
        "Wed 6/15 - Cloudy - 31/17",
        "Thurs 6/16 - Rainy - 31/17",
        "Fri 6/17 - Foggy - 31/17",
        "Sat 6/18 - TRAPPED IN WEATHERSTATION - 31/17",
        "Sun 6/19 - Sunny - 31/17"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = WeatherListAdatper(items)
        getNetData()
        getNetData2()
    }

    fun getNetData() {
        val url = COMPLETE_URL + 94043
        async() {
            var result = RequestForecastCommand("94043").execute()
            uiThread {
                longToast("已经执行请求")
                var weatherListAdatper = WeatherListAdatper(result)
                recyclerView.adapter = weatherListAdatper
            }
        }
    }

    private fun getNetData2() = async(UI) {
        val url = COMPLETE_URL + 94043
        bg {
            Request(url).run()
            runOnUiThread { toast("执行请求") }
        }
    }
}