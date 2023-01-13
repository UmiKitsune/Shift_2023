package com.example.shift_tz_2023.domain

import androidx.lifecycle.LiveData

interface CardInfoRepository {
    suspend fun getCardInfoByBIN(bin: Int): UiCardInfoModel

    suspend fun insertBankToDB(bin: Int, bank: BankUI)

    suspend fun insertCardInfoToDB(bin:Int, brand: String, prepaid: Boolean, scheme: String, type: String)

    suspend fun insertNumberToDB(bin:Int, number: NumberUI)

    suspend fun insertCountryToDB(bin:Int, countryUI: CountryUI)

    fun getDataFromDB(): LiveData<List<UiCardInfoModel>>
}