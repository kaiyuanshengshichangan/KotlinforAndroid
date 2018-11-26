package com.example.changan.kotlin_for_android_copy.server
/**
 * 服务器数据,用来存放多个实体数据类
* */

/**
 * 天气预报结果集
 */
data class ForecastResult(val city: City, val list: List<Forecast>)

/**
 * 城市实体数据类
 */
data class City(val id: Long, val name: String, val coord: Coordinates, val country: String, val population: Int)

/**
 * 城市实体数据类
 */
data class Coordinates(val lon: Float, val lat: Float)

/**
 * 预报实体数据类
 */
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int,
                    val weather: List<Weather>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

/**
 * 气温实体数据类
 */
data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val mon: Float)

/**
 * 天气实体数据类
 */
data class Weather(val id: Long, val main: String, val description: String, val icon: String)