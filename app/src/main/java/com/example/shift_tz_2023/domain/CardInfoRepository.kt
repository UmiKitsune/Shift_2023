package com.example.shift_tz_2023.domain

import com.example.shift_tz_2023.data.web.model.CardInfoModel

interface CardInfoRepository {
    suspend fun getCardInfoByBIN(bin: Int): CardInfoModel
}