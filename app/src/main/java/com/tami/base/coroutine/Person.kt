package com.tami.base.coroutine


data class PersonList(
    val persons: ArrayList<Person>
)

data class Person(
    val name: String,
    val age: Int
)