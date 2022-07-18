package com.example.psaweathertest.common

sealed class Resources <T>(val data:T?=null, val message: String ="", val loading: Boolean =false) {
    class Success<T>(data: T?) : Resources<T>(data=data)
    class Error<T>(error: String) : Resources<T>(message = error)
    class Loading<T> : Resources<T>(loading=true)
}