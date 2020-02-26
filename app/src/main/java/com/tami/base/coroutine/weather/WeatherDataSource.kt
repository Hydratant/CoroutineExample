package com.tami.base.coroutine.weather

interface WeatherDataSource {

    suspend fun getWeather()

}