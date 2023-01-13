package com.example.shift_tz_2023.presentation

import androidx.lifecycle.ViewModel
import com.example.shift_tz_2023.domain.usecase.GetDataFromDB

class HistoryViewModel(
    private val getDataFromDB: GetDataFromDB
): ViewModel() {

    val dataFromDB = getDataFromDB

}