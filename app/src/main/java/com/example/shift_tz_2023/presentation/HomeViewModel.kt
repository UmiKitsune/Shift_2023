package com.example.shift_tz_2023.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_tz_2023.domain.UiCardInfoModel
import com.example.shift_tz_2023.domain.usecase.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCardInfo: GetCardInfoByBIN,
    private val insertBankToDB: InsertBankToDB,
    private val insertCardInfoToDB: InsertCardInfoToDB,
    private val insertCountryToDB: InsertCountryToDB,
    private val insertNumberToDB: InsertNumberToDB
): ViewModel() {

    private var _cardInfo = MutableLiveData<UiCardInfoModel>()
    val cardInfo: LiveData<UiCardInfoModel> = _cardInfo

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

    fun insertData(model:UiCardInfoModel) = viewModelScope.launch {
        insertBankToDB(model.bin, model.bank)
        insertCardInfoToDB(model.bin, model.brand, model.prepaid, model.scheme, model.type)
        insertCountryToDB(model.bin,model.country)
        insertNumberToDB(model.bin, model.number)
    }

}

