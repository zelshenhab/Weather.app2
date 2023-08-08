package com.example.weather.domain.weather

data class WeatherInfo(
    val name: String,
    val icon: String?,
    val temperature: Double,
    val windDegree: Int,
    val humidity: Int,
    val lat: Double?,
    val lon: Double?,
)
