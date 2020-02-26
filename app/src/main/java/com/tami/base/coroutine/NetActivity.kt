package com.tami.base.coroutine

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.tami.base.BaseActivity
import kotlinx.android.synthetic.main.activity_net.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NetActivity : BaseActivity() {

    private val vm: NetViewModel by viewModel()

    private val adapter: PersonAdapter by lazy { PersonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net)
        vm.getPerson()

        vm.successPerson.observe(this, Observer {
            it?.let {
                Log.e("netActivity", it.persons.size.toString())
                recycler.adapter = adapter
                adapter.set(it.persons)
            }
        })
    }
}