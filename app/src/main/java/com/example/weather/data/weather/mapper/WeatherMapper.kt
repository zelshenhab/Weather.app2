package com.example.weather.data.weather.mapper

import com.example.weather.data.weather.datasource.remote.response.WeatherResponse
import com.example.weather.domain.weather.WeatherInfo

fun WeatherResponse.toWeatherInfo(): WeatherInfo = WeatherInfo(
    name = name,
    icon = weather.firstOrNull()?.icon,
    temperature = main.temp,
    windDegree = wind.deg,
    humidity = main.humidity,
    lat = coord?.lat,
    lon = coord?.lon,
)
