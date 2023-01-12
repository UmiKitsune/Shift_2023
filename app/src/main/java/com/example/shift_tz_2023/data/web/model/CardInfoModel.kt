package com.example.shift_tz_2023.data.web.model

data class CardInfoModel(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)