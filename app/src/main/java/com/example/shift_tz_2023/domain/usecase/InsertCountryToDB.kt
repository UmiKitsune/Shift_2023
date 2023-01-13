package com.example.shift_tz_2023.domain.usecase

import com.example.shift_tz_2023.domain.CardInfoRepository
import com.example.shift_tz_2023.domain.CountryUI

class InsertCountryToDB(private val repository: CardInfoRepository) {
    suspend operator fun invoke(bin: Int, countryUI: CountryUI) =
        repository.insertCountryToDB(bin, countryUI)
}