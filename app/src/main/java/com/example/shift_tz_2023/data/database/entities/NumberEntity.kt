package com.example.shift_tz_2023.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number")
data class NumberEntity(
    @PrimaryKey
    val bin: Int,
    val length: Int,
    val luhn: Boolean
)