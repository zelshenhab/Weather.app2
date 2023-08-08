package com.example.weather.data.weather.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.weather.data.weather.datasource.remote.response.WeatherResponse

interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String?
    ): WeatherResponse

}
