package com.example.psaweathertest.common

import java.lang.Exception

interface ErrorHandler {
    fun handleException(exception: Exception): String
}