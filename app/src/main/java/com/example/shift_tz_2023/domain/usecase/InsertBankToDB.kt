package com.example.shift_tz_2023.domain.usecase

import com.example.shift_tz_2023.data.web.model.Bank
import com.example.shift_tz_2023.domain.BankUI
import com.example.shift_tz_2023.domain.CardInfoRepository

class InsertBankToDB(private val repository: CardInfoRepository) {
    suspend operator fun invoke(bin: Int, bank: BankUI) =
        repository.insertBankToDB(bin, bank)
}