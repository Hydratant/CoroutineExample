@file:Suppress("SpellCheckingInspection")

package com.tami.base.coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class NetViewModel(private val personRepository: PersonRepository) : ViewModel() {

    private val job = Job()

    private val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val scope = CoroutineScope(coroutineContext)

    private val _successPerson = MutableLiveData<PersonList>()
    val successPerson: LiveData<PersonList> get() = _successPerson


    fun getPerson() {
        scope.launch {
            val person = personRepository.getPerson()
            _successPerson.postValue(person)

//            val test = async {
//                return@async personRepository.getPerson()
//            }
//            val ss = test.await()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}