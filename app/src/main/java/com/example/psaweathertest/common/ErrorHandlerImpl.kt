package com.example.psaweathertest.common

import android.util.MalformedJsonException
import java.io.IOException
import javax.inject.Inject


class ErrorHandlerImpl @Inject constructor() : ErrorHandler {

    override fun handleException(exception: Exception): String {
        if (exception.message == "HTTP 404 Not Found")
            return "City not found, please type in a valid city name"
        return when (exception) {
            is IOException -> "Unable to connect to server , continuing in offline mode"
            is MalformedJsonException -> "Unexpected response from server"
            else -> exception.message ?: ""

        }
    }

}