package com.example.shift_tz_2023.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank")
data class BankEntity(
    @PrimaryKey
    val bin: Int,
    val city: String,
    val name: String,
    val phone: String,
    val url: String
)