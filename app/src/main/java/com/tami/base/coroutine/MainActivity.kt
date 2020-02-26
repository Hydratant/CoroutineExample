package com.tami.base.coroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    // CoroutineScope의 동작을 제어할 객체
// 안드로이드 상에서는 Lifecycle을 활용할 수 있도록 도와준다.
    lateinit var job: Job
    // coroutine의 스레드를 어떠한 형태로 사용할지 지정할 수 있다.
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()

        test2()

//        runBlocking {
//            main()
//        }
//        CoroutineScope(coroutineContext).launch {
//            main()
//        }
        Log.e("main", " 밑")
        test.setOnClickListener {

            startActivity(Intent(this, NetActivity::class.java))
        }
    }

    suspend fun main() = coroutineScope {
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

    fun test2() {
        runBlocking {
            delay(1000L)
            Log.e("main", "STEP 1")
        }
        Log.e("main", "STEP 2")
        CoroutineScope(coroutineContext).launch {
            delay(1000L)
            Log.e("main", "STEP 4")
        }
        Log.e("main", "STEP 3")
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}
