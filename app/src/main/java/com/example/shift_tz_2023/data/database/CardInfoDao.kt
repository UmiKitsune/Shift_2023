package com.example.shift_tz_2023.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shift_tz_2023.data.database.entities.*

@Dao
interface CardInfoDao {
    //todo: возможно убрать (onConflict = OnConflictStrategy.REPLACE)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardInfo(cardInfoEntity: CardInfoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBank(bankEntity: BankEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumber(numberEntity: NumberEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countryEntity: CountryEntity)

    @Transaction
    @Query("SELECT * FROM cardInfo")
     fun getFullCardInformation(): LiveData<List<FullCardInfo>>

    @Transaction
    @Query("SELECT * FROM bank")
     fun getBank(): LiveData<List<BankEntity>>
}