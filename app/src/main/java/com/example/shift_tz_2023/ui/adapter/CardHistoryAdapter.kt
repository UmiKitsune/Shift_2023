package com.example.shift_tz_2023.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shift_tz_2023.data.web.model.CardInfoModel
import com.example.shift_tz_2023.databinding.ItemHistoryBinding
import com.example.shift_tz_2023.domain.UiCardInfoModel

class CardHistoryAdapter: RecyclerView.Adapter<CardHistoryViewHolder>() {

    // TODO: поменять  CardInfoModel на модель в папке domain + mapper
    var cardInfoList: List<UiCardInfoModel> = emptyList()
    set(newValue) {
        field = newValue
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return CardHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHistoryViewHolder, position: Int) {
        val cardInfo = cardInfoList[position]
        holder.bind(cardInfo)
    }

    override fun getItemCount(): Int = cardInfoList.size
}