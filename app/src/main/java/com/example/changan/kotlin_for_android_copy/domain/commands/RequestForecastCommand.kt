package com.example.changan.kotlin_for_android_copy.domain.commands

import com.example.changan.kotlin_for_android_copy.domain.ForecastDataMapper
import com.example.changan.kotlin_for_android_copy.domain.models.ForecastList
import com.example.changan.kotlin_for_android_copy.server.ForecastRequest

class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        var execute = forecastRequest.execute()
        return ForecastDataMapper().convertFromDataModel(execute)
    }

}