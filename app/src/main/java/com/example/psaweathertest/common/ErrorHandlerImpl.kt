package com.example.psaweathertest.common

import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class ErrorHandlerImpl @Inject constructor() : ErrorHandler {
    override fun handleException(exception: Exception): String =
        when (exception) {
            is IOException -> "Network failure , the app is in offline mode"

            else -> exception.message ?: ""

        }


}