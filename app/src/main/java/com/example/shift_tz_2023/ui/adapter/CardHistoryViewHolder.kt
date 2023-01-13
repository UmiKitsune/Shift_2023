package com.example.shift_tz_2023.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.shift_tz_2023.data.web.model.CardInfoModel
import com.example.shift_tz_2023.databinding.ItemHistoryBinding
import com.example.shift_tz_2023.domain.UiCardInfoModel

class CardHistoryViewHolder(
    private val binding: ItemHistoryBinding
): RecyclerView.ViewHolder(binding.root) {

    // TODO: добавить бин из поля в предыдущем фрагменте

    fun bind(info: UiCardInfoModel) {
        with(binding) {
            itemBIN.text = info.bin.toString()
            itemScheme.text = info.scheme
            itemBankName.text = info.bank.name
        }
    }

}