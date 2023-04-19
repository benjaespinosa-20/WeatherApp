package com.example.weatherapp.model.repository

import com.example.weatherapp.core.AppConstants
import com.example.weatherapp.model.response.WeatherResponse
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(val webService: WebService): WeatherRepository {
    override suspend fun getWeather(): WeatherResponse = webService.getWeather(AppConstants.API_KEY)
}