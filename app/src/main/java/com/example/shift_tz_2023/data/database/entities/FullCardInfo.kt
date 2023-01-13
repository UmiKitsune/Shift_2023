package com.example.shift_tz_2023.data.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class FullCardInfo(
    @Embedded val cardInfo: CardInfoEntity,
    @Relation(
        parentColumn = "bin",
        entityColumn = "bin"
    ) val bank: BankEntity,
    @Relation(
        parentColumn = "bin",
        entityColumn = "bin"
    ) val country: CountryEntity,
    @Relation(
        parentColumn = "bin",
        entityColumn = "bin"
    ) val number: NumberEntity
)