package com.example.shift_tz_2023.data.web

import com.example.shift_tz_2023.data.web.model.CardInfoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetInfoApi {
    @GET("{bin}")
    suspend fun getCardInfo(
        @Path("bin") bin: Int
    ): Response<CardInfoModel>
}