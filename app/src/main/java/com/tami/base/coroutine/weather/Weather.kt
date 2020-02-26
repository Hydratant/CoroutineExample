package com.tami.base.coroutine.weather

data class Weather(
    val response: Response
)

data class Response(
    val body: Body,
    val header: Header
)

data class Body(
    val dataType: String,
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)

data class Items(
    val item: List<Item>
)

data class Item(
    val baseDate: String,     // 발표일자
    val baseTime: String,     // 발표시각
    val category: String,     // 자료구분문자
    val fcstDate: String,     // 예보일자
    val fcstTime: String,     // 예보시각
    val fcstValue: String,    // 예보 값
    val nx: Int,              // 예보지점X좌표
    val ny: Int               // 예보지점Y좌표
)

data class Header(
    val resultCode: String,
    val resultMsg: String
)