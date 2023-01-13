package com.example.shift_tz_2023.domain.usecase

import com.example.shift_tz_2023.domain.CardInfoRepository

class InsertCardInfoToDB(private val repository: CardInfoRepository) {
    suspend operator fun invoke(bin:Int, brand: String, prepaid: Boolean, scheme: String, type: String) =
        repository.insertCardInfoToDB(bin, brand, prepaid, scheme, type)
}