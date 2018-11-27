package com.example.changan.kotlin_for_android_copy.domain

import com.example.changan.kotlin_for_android_copy.domain.models.ForecastList
import com.example.changan.kotlin_for_android_copy.domain.models.ForecastTr
import com.example.changan.kotlin_for_android_copy.server.Forecast
import com.example.changan.kotlin_for_android_copy.server.ForecastResult
import java.text.DateFormat
import java.util.*


/**
 * 将请求的实体转换成需要显示的实体，映射（数据转换）
 */
public class ForecastDataMapper {

    fun convertFromDataModel(forecastResult: ForecastResult): ForecastList {
        return ForecastList(forecastResult.city.name, forecastResult.city.country, convertForecastListToDomain(forecastResult.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ForecastTr> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ForecastTr {
        return ForecastTr(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min
            .toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png";
}