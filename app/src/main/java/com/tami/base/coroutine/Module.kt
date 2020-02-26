package com.tami.base.coroutine

import com.tami.base.coroutine.net.Net
import com.tami.base.coroutine.net.createNetService
import com.tami.base.coroutine.weather.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { NetViewModel(get()) }
    single<PersonDataSource> { PersonDataSourceImpl(androidApplication()) }
    single<PersonRepository> { PersonRepositoryImpl(get()) }

    single { Net(BASE_URL = Key.BASE_URL) }
    single<WeatherDataSource> { createNetService(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    viewModel { WeatherViewModel(get()) }

}