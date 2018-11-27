package com.example.changan.kotlin_for_android_copy.domain.models

data class ForecastList(val city: String, val country: String, val dailyForecastList: List<ForecastTr>) {
    operator fun get(position: Int): ForecastTr = dailyForecastList[position]

    fun size() = dailyForecastList.size
}

/**
 * 被转换后的实体
 */
data class ForecastTr(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)