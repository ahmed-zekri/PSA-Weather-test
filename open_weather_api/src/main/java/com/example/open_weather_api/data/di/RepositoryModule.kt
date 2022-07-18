package com.example.open_weather_api.data.di

import com.example.open_weather_api.data.repositories.RemoteRemoteWeatherRepositoryImpl
import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providesWeatherRepository(remoteWeatherRepositoryImpl: RemoteRemoteWeatherRepositoryImpl): RemoteWeatherRepository
}