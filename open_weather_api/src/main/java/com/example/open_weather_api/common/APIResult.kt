package com.example.open_weather_api.common

sealed class APIResult <T>(val data:T?=null,val message: String ="",val loading: Boolean =false) {
    class Success<T>(data: T?) : APIResult<T>(data=data)
    class Error<T>(error: String) : APIResult<T>(message = error)
    class Loading<T> : APIResult<T>(loading=true)
}