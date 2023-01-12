package com.example.shift_tz_2023.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_tz_2023.data.CardInfoRepositoryImpl
import com.example.shift_tz_2023.data.web.model.CardInfoModel
import com.example.shift_tz_2023.domain.usecase.GetCardInfoByBIN
import kotlinx.coroutines.*

class HomeViewModel: ViewModel() {

    private val getCardInfo = GetCardInfoByBIN(CardInfoRepositoryImpl())

    private var _cardInfo = MutableLiveData<CardInfoModel>()
    val cardInfo: LiveData<CardInfoModel> = _cardInfo

    private var _emptyField = MutableLiveData<Unit>()
    val emptyField:  LiveData<Unit>  = _emptyField

    fun onSearchButtonClick(bin: String) = viewModelScope.launch {
        if (bin.isEmpty() || bin.length < 6) {
            _emptyField.value = Unit
        } else {
            _cardInfo.value = CoroutineScope(Dispatchers.IO).async {
                getCardInfo.invoke(bin.toInt())
            }.await()
        }
    }


}

