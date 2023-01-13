package com.example.shift_tz_2023.domain

data class UiCardInfoModel(
    val bin: Int,
    val bank: BankUI,
    val brand: String,
    val country: CountryUI,
    val number: NumberUI,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)

data class BankUI(
    val city: String,
    val name: String,
    val phone: String,
    val url: String
)

data class CountryUI(
    val alpha2: String,
    val currency: String,
    val emoji: String,
    val latitude: Int,
    val longitude: Int,
    val name: String,
    val numeric: String
)

data class NumberUI(
    val length: Int,
    val luhn: Boolean
)