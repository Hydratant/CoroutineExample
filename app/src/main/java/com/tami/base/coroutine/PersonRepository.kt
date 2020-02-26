package com.tami.base.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PersonRepository {
    suspend fun getPerson(): PersonList
}

class PersonRepositoryImpl(private val personDataSource: PersonDataSource) : PersonRepository {
    override suspend fun getPerson(): PersonList = withContext(Dispatchers.IO) { personDataSource.getPerson() }
}