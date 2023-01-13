package com.example.shift_tz_2023.domain.usecase

import com.example.shift_tz_2023.domain.CardInfoRepository
import com.example.shift_tz_2023.domain.NumberUI

class InsertNumberToDB(private val repository: CardInfoRepository) {
    suspend operator fun invoke(bin: Int, number: NumberUI) =
        repository.insertNumberToDB(bin, number)
}