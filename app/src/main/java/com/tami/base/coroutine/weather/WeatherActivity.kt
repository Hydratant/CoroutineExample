package com.tami.base.coroutine.weather

import android.os.Bundle
import com.tami.base.BaseActivity
import com.tami.base.coroutine.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : BaseActivity() {

    private val vm: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        vm.getWeather()
    }
}