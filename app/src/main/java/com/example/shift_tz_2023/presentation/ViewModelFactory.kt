package com.example.shift_tz_2023.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shift_tz_2023.data.CardInfoRepositoryImpl
import com.example.shift_tz_2023.domain.usecase.*

class ViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val repo = CardInfoRepositoryImpl(context)

    private val getCardInfo = GetCardInfoByBIN(repo)
    private val insertBankToDB = InsertBankToDB(repo)
    private val insertCardInfoToDB = InsertCardInfoToDB(repo)
    private val insertCountryToDB = InsertCountryToDB(repo)
    private val insertNumberToDB = InsertNumberToDB(repo)
    private val getDataFromDB = GetDataFromDB(repo)


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val viewModel = when(modelClass) {
            HomeViewModel::class.java -> {
                HomeViewModel(
                    getCardInfo,
                    insertBankToDB,
                    insertCardInfoToDB,
                    insertCountryToDB,
                    insertNumberToDB
                )
            }
            HistoryViewModel::class.java -> {
                HistoryViewModel(getDataFromDB)
            }
            FullInfoViewModel::class.java -> {
                FullInfoViewModel(getDataFromDB)
            }
            else -> throw IllegalStateException("Unknown view model class")
        }
        return viewModel as T
    }
}