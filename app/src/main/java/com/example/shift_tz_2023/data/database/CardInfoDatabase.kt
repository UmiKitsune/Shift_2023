package com.example.shift_tz_2023.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shift_tz_2023.data.database.entities.BankEntity
import com.example.shift_tz_2023.data.database.entities.CardInfoEntity
import com.example.shift_tz_2023.data.database.entities.CountryEntity
import com.example.shift_tz_2023.data.database.entities.NumberEntity

@Database(
    entities = [
        CardInfoEntity::class,
        BankEntity::class,
        CountryEntity::class,
        NumberEntity::class
    ], version = 1, exportSchema = false)
abstract class CardInfoDatabase : RoomDatabase() {
    companion object {
        private var db: CardInfoDatabase? = null
        private const val DB_NAME = "cardHistory.db"
        private val LOCK = Any()

        fun getInstance(context: Context): CardInfoDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        CardInfoDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun getDao(): CardInfoDao
}