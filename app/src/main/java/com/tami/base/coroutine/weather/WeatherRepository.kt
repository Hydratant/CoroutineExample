package com.tami.base.coroutine.weather

interface WeatherRepository {
    suspend fun getWeather(base_date: String, base_time: String): Weather
}

class WeatherRepositoryImpl(private val weatherDataSource: WeatherDataSource) : WeatherRepository {
    override suspend fun getWeather(base_date: String, base_time: String): Weather =
            weatherDataSource.getWeather(Key.SERVICE_KEY, 10, 1, "JSON", base_date, base_time, 56, 125)
}