package com.example.psaweathertest.common

import java.util.*

fun Int.toDate(): Date {
    val d = Date()
    val localTime = d.time
    val localOffset = d.timezoneOffset * 60000
    val utc = localTime + localOffset
    val time = utc + (1000 * this)
    return Date(time)


}