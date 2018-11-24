package com.example.changan.kotlin_for_android_copy.ui.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.changan.kotlin_for_android_copy.R
import com.example.changan.kotlin_for_android_copy.ui.activitys.adapter.WeatherListAdatper
import kotlinx.android.synthetic.main.activity_weather_list.*

/**
 * 天气列表
 */
class WeatherListActivity : AppCompatActivity() {

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
        recyclerView.adapter = WeatherListAdatper(items)
    }

    fun createData() {

    }
}