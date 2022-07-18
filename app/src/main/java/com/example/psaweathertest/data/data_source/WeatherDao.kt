package com.example.psaweathertest.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.psaweathertest.domain.model.Weather
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather")
    fun getData(): Flow<List<Weather>>

    @Query("SELECT * FROM weather WHERE city=:cityName")
    suspend fun getDataByCityName(cityName: String): Weather?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(weather: Weather)






}