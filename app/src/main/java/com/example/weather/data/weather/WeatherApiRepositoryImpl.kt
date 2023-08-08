package com.example.weather.data.weather

import com.example.weather.data.weather.datasource.remote.WeatherApi
import com.example.weather.data.weather.mapper.toWeatherInfo
import com.example.weather.domain.weather.WeatherInfo
import com.example.weather.domain.weather.WeatherApiRepository

class WeatherApiRepositoryImpl(
    private val weatherApi: WeatherApi
): WeatherApiRepository {

    override suspend fun getWeatherByName(
        query: String?
    ): WeatherInfo = weatherApi.getWeather(query).toWeatherInfo()

}
