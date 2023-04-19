package com.example.weatherapp.model.repository

import com.example.weatherapp.model.response.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(): WeatherResponse
}