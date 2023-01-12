package com.example.shift_tz_2023.data

import com.example.shift_tz_2023.data.web.RetrofitFactory
import com.example.shift_tz_2023.data.web.model.CardInfoModel
import com.example.shift_tz_2023.domain.CardInfoRepository

class CardInfoRepositoryImpl() : CardInfoRepository {
    override suspend fun getCardInfoByBIN(bin: Int): CardInfoModel {
        return RetrofitFactory.api.getCardInfo(bin).body()!!
        //todo: сделать через try catch
    }
}