package com.example.psaweathertest.data.di

import com.example.psaweathertest.common.ErrorHandler
import com.example.psaweathertest.common.ErrorHandlerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonModule {
    @Binds
    @Singleton
   abstract fun providesErrorHandler(
        errorHandlerImpl: ErrorHandlerImpl
    ): ErrorHandler


}