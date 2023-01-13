package com.example.shift_tz_2023.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cardInfo")
data class CardInfoEntity(
    @PrimaryKey
    val bin: Int,
    //val bank: BankEntity,
    val brand: String,
    //val country: CountryEntity,
    //val number: NumberEntity,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)