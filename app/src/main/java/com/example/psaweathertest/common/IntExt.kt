package com.example.psaweathertest.common

import android.os.Build
import java.time.Instant
import java.time.ZoneId
import kotlin.math.abs


fun Int.toDate(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val utc = Instant.now()
        val utcZoneDateTime = utc.atZone(ZoneId.of("UTC"))
        val cityDateTime = utcZoneDateTime.plusSeconds(this.toLong())


        "${cityDateTime.dayOfMonth.minTwoDigits()}/${cityDateTime.monthValue.minTwoDigits()}/${cityDateTime.year} ${cityDateTime.hour.minTwoDigits()}:${cityDateTime.minute.minTwoDigits()} GMT${if (this / 3600 < 0) "-" else "+"}${(this / 3600).minTwoDigits()}"

    } else {
        ""
    }


}

fun Int.minTwoDigits() = (if (this / 10 < 1) "0" else "") + abs(this).toString()
