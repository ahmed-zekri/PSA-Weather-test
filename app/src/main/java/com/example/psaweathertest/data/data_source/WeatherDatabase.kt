package com.example.psaweathertest.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.psaweathertest.common.DATABASE_VERSION
import com.example.psaweathertest.domain.model.Weather


@Database(entities = [Weather::class], version = DATABASE_VERSION)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val weatherDao: WeatherDao
}