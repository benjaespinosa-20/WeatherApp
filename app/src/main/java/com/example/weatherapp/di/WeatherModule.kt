package com.example.weatherapp.di

import com.example.weatherapp.core.AppConstants
import com.example.weatherapp.model.repository.WeatherRepository
import com.example.weatherapp.model.repository.WeatherRepositoryImp
import com.example.weatherapp.model.repository.WebService
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
abstract class WeatherModule {
    @Binds
    abstract fun bindWeatherRepository(watherRepositoryImp: WeatherRepositoryImp): WeatherRepository

    companion object {
        @Provides
        fun providesRetrofitInstance(): Retrofit {

            val loggingInterceptor = HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

        @Provides
        fun providesWebService(retrofit: Retrofit) = retrofit.create<WebService>()
    }

}