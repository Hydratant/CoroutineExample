package com.tami.base.coroutine.weather

import retrofit2.http.*

interface WeatherDataSource {

    @GET("1360000/VilageFcstInfoService/getVilageFcst")
    suspend fun getWeather(
            @Query(value = "serviceKey", encoded = true) serviceKey: String,     // 서비스키
            @Query("numOfRows") numOfRows: Int,          // 한 페이지 결과 수
            @Query("pageNo") pageNo: Int,                // 페이지 번호
            @Query("dataType") dataType: String,         // 응답자료형식 ( XML, JSON )
            @Query("base_date") base_date: String,       // 발표일자
            @Query("base_time") base_time: String,       // 발표시각
            @Query("nx") nx: Int,                        // 예보지점 X 좌표
            @Query("ny") ny: Int                         // 예보지점 Y 좌표
    ): Weather

}