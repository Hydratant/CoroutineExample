package com.tami.base.coroutine

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { NetViewModel(get()) }
    single<PersonDataSource> { PersonDataSourceImpl(androidApplication()) }
    single<PersonRepository> { PersonRepositoryImpl(get()) }
}