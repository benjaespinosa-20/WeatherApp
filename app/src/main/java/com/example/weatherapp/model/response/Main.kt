package com.example.weatherapp.model.response

data class Main(
     val temp: Int,
    val feels_like: Int,
 val temp_min: Int,
val temp_max: Int,
val pressure: Int,
val humidity: Int,
val sea_level: Int,
val grnd_level: Int
)
