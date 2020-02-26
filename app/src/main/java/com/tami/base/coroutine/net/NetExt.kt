package com.tami.base.coroutine.net




inline fun <reified T> createNetService(net: Net): T {
    return net.retrofit.create(T::class.java)
}
