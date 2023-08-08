package com.example.weather.domain.weather

interface WeatherApiRepository {

    suspend fun getWeatherByName(query: String?): WeatherInfo

}
