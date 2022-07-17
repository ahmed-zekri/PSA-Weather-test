package com.example.open_weather_api.data.di

import com.example.open_weather_api.common.BASE_URL
import com.example.open_weather_api.data.remote.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun providesApi(): WeatherApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())

            .baseUrl(BASE_URL)
            .build().create(WeatherApi::class.java);

}