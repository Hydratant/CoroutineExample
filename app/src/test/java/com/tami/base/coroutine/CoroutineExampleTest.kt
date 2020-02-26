@file:Suppress("TestFunctionName", "SpellCheckingInspection")

package com.tami.base.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CoroutineExampleTest {
    @Test
    fun 일반함수() {
        일반테스트함수1()
        일반테스트함수2()
    }

    private fun 일반테스트함수1() {
        println("일반 Step 1")
    }

    private fun 일반테스트함수2() {
        println("일반 Step 2")
    }

    @Test
    fun 코루틴함수() {
//        GlobalScope.launch {
//            delay(1000L)
//            일반테스트함수1()
//        }
//        일반테스트함수2()
//        Thread.sleep(2000L)

        runBlocking {
            delay(1000L)
            일반테스트함수1()
        }
        일반테스트함수2()
        Thread.sleep(2000L)
    }
}