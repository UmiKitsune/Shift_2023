package com.example.shift_tz_2023.domain.usecase

import com.example.shift_tz_2023.data.web.model.CardInfoModel
import com.example.shift_tz_2023.domain.CardInfoRepository

class GetCardInfoByBIN(private val repository: CardInfoRepository) {
    suspend operator fun invoke(bin: Int): CardInfoModel =
        repository.getCardInfoByBIN(bin)
}