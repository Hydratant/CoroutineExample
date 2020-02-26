package com.tami.base.coroutine

import android.util.Log
import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun coroutineFirst() {
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        Thread.sleep(2000L)
    }

    @Test
    fun coroutine2() {
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        runBlocking {
            delay(2000L)
        }

        print("test")
    }

    //CoroutineScope는 runBlocking 내부에서만 사용 가능
    //runBlocking, coroutineScope 차이점
    //coroutineScope에서는 자식 스레드가 완료될 때 까지 현재 스레드를 block 하지 않는다.
    //runBlocking에서는 자식 스레드가 완료될 때 까지 현재 스레드를 block 한다.
    @Test
    fun corountine4() {
        runBlocking {
            launch {
                delay(200L)
                Log.e("main", "Task from runBlocking")
            }
            coroutineScope {
                launch {
                    delay(500L)
                    Log.e("main", "Task from nested launch")
                }
                delay(100L)
                Log.e("main", "Task from coroutine scope")
            }
            Log.e("main", "Coroutine scope is over")
        }
    }
}



