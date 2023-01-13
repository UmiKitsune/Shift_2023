package com.example.shift_tz_2023.domain.usecase

import androidx.lifecycle.LiveData
import com.example.shift_tz_2023.domain.CardInfoRepository
import com.example.shift_tz_2023.domain.UiCardInfoModel

class GetDataFromDB(private val repository: CardInfoRepository) {
    operator fun invoke(): LiveData<List<UiCardInfoModel>> =
        repository.getDataFromDB()
}