package com.example.shift_tz_2023.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shift_tz_2023.data.database.CardInfoDatabase
import com.example.shift_tz_2023.data.database.entities.BankEntity
import com.example.shift_tz_2023.data.database.entities.CardInfoEntity
import com.example.shift_tz_2023.data.database.entities.CountryEntity
import com.example.shift_tz_2023.data.database.entities.NumberEntity
import com.example.shift_tz_2023.data.web.RetrofitFactory
import com.example.shift_tz_2023.domain.*

class CardInfoRepositoryImpl(context: Context) : CardInfoRepository {

    private val dao = CardInfoDatabase.getInstance(context).getDao()

    override suspend fun getCardInfoByBIN(bin: Int): UiCardInfoModel {
        return Mapper.toUICardInfoModelFromAPI(bin, RetrofitFactory.api.getCardInfo(bin).body()!!)
        //todo: сделать через try catch
    }

    override suspend fun insertBankToDB(bin: Int, bank: BankUI) {
        dao.insertBank(BankEntity(bin, bank.city, bank.name, bank.phone, bank.url))
    }

    override suspend fun insertNumberToDB(bin: Int, number: NumberUI) {
        dao.insertNumber(NumberEntity(bin, number.length, number.luhn))
    }

    override suspend fun insertCountryToDB(bin: Int, countryUI: CountryUI) {
        dao.insertCountry(
            CountryEntity(
                bin,
                countryUI.alpha2,
                countryUI.currency,
                countryUI.emoji,
                countryUI.latitude,
                countryUI.longitude,
                countryUI.name,
                countryUI.numeric
            )
        )
    }

    override suspend fun insertCardInfoToDB(
        bin: Int,
        brand: String,
        prepaid: Boolean,
        scheme: String,
        type: String
    ) {
        dao.insertCardInfo(CardInfoEntity(bin, brand, prepaid, scheme, type))
    }

    override fun getDataFromDB(): LiveData<List<UiCardInfoModel>> {
        return Transformations.map(dao.getFullCardInformation()) { full ->
            return@map Mapper.toUICardInfoModelFromDB(full)
        }
    }
}

