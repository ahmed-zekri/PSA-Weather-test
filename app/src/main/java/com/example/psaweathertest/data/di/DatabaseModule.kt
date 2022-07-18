package com.example.psaweathertest.data.di

import android.app.Application
import androidx.room.Room
import com.example.psaweathertest.common.DATABASE_NAME
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
    fun providesDatabase(@ApplicationContext application: Application): WeatherDatabase =
        Room.databaseBuilder(application, WeatherDatabase::class.java, DATABASE_NAME).build()
}