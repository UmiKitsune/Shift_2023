package com.example.shift_tz_2023.domain

data class UiCardInfoModel(
    val bin: Int,
    val bank: BankUI = BankUI(),
    val brand: String = "",
    val country: CountryUI = CountryUI(),
    val number: NumberUI = NumberUI(),
    val prepaid: Boolean = false,
    val scheme: String = "",
    val type: String = ""
)

data class BankUI(
    val city: String = "",
    val name: String = "",
    val phone: String = "",
    val url: String = ""
)

data class CountryUI(
    val alpha2: String = "",
    val currency: String = "",
    val emoji: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val name: String = "",
    val numeric: String = ""
)

data class NumberUI(
    val length: Int = 0,
    val luhn: Boolean = false
)