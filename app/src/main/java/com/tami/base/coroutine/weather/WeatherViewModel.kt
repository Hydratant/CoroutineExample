package com.tami.base.coroutine.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {


    private val job = Job()

    private val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val scope = CoroutineScope(coroutineContext)

    fun getWeather() {
        scope.launch {
            val weather = weatherRepository.getWeather("20200226", "1400")
            Log.i("WeatherViewModel", "weather Success")
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}