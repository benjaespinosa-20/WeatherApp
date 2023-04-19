package com.example.weatherapp.model.repository

import com.example.weatherapp.model.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("weather")
    suspend fun getWeather(@Query("api_key") apiKey: String): WeatherResponse
}