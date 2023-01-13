package com.example.shift_tz_2023.data

import androidx.lifecycle.LiveData
import com.example.shift_tz_2023.data.database.entities.FullCardInfo
import com.example.shift_tz_2023.data.web.model.CardInfoModel
import com.example.shift_tz_2023.domain.BankUI
import com.example.shift_tz_2023.domain.CountryUI
import com.example.shift_tz_2023.domain.NumberUI
import com.example.shift_tz_2023.domain.UiCardInfoModel

object Mapper {
    fun toUICardInfoModelFromAPI(bin: Int,cardInfo: CardInfoModel):UiCardInfoModel {
        val bank = cardInfo.bank
        val country = cardInfo.country
        val number = cardInfo.number
        return UiCardInfoModel(
            bin,
            BankUI(bank.city, bank.name, bank.phone, bank.url),
            cardInfo.brand,
            CountryUI(
                country.alpha2,
                country.currency,
                country.emoji,
                country.latitude,
                country.longitude,
                country.name,
                country.numeric
            ),
            NumberUI(number.length, number.luhn),
            cardInfo.prepaid,
            cardInfo.scheme,
            cardInfo.type
        )
    }

    fun toUICardInfoModelFromDB (dbList: List<FullCardInfo>): List<UiCardInfoModel> {
        return dbList.map { dbInfo ->
            val bank = dbInfo.bank
            val country = dbInfo.country
            val number = dbInfo.number
            val info = dbInfo.cardInfo
            UiCardInfoModel(
                info.bin,
                BankUI(bank.city, bank.name, bank.phone, bank.url),
                info.brand,
                CountryUI(
                    country.alpha2,
                    country.currency,
                    country.emoji,
                    country.latitude,
                    country.longitude,
                    country.name,
                    country.numeric
                ),
                NumberUI(number.length, number.luhn),
                info.prepaid,
                info.scheme,
                info.type
            )
        }

    }

}