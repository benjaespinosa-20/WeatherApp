package com.example.weatherapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.weatherapp.core.Resource
import com.example.weatherapp.model.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(val repository: WeatherRepository) : ViewModel() {
    fun getWeather() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            val response = repository
            when(response != null){
                true -> emit(Resource.Succes(response))
                false -> emit(Resource.Failure(java.lang.Exception("failure")))
            }
        }catch (e: Exception){
            Log.e("CriptoTickerViewModel", "failure call")
            emit(Resource.Failure(e))
        }
    }
}