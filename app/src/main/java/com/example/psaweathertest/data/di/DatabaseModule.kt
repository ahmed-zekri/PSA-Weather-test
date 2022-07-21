package com.example.psaweathertest.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.psaweathertest.common.DATABASE_NAME
import com.example.psaweathertest.data.data_source.WeatherDao
import com.example.psaweathertest.data.data_source.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(app: Application): WeatherDatabase =
        Room.databaseBuilder(app, WeatherDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesWeatherDao(weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.weatherDao
    }
}