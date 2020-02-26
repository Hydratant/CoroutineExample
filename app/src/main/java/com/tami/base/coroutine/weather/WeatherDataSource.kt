package com.tami.base.coroutine.weather

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WeatherDataSource {

    @POST("1360000/VilageFcstInfoService")
    @FormUrlEncoded
    suspend fun getWeather(
            @Field("serviceKey") serviceKey: String,     // 서비스키
            @Field("numOfRows") numOfRows: Int,          // 한 페이지 결과 수
            @Field("pageNo") pageNo: Int,                // 페이지 번호
            @Field("dataType") dataType: String,         // 응답자료형식 ( XML, JSON )
            @Field("base_date") base_date: String,       // 발표일자
            @Field("base_time") base_time: String,       // 발표시각
            @Field("nx") nx: Int,                        // 예보지점 X 좌표
            @Field("ny") ny: Int                         // 예보지점 Y 좌표
    ): Weather

}