package com.tami.base.coroutine

import android.app.Application
import com.google.gson.Gson
import com.tami.base.raw2string

interface PersonDataSource {
    suspend fun getPerson(): PersonList
}

class PersonDataSourceImpl(private val ap: Application) : PersonDataSource {
    override suspend fun getPerson(): PersonList {
        val context = ap.applicationContext
        val personJsonText = context.raw2string(R.raw.person)
        return Gson().fromJson(personJsonText, PersonList::class.java)
    }
}