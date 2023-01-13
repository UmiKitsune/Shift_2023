package com.example.shift_tz_2023.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shift_tz_2023.databinding.FragmentHistoryBinding
import com.example.shift_tz_2023.domain.UiCardInfoModel
import com.example.shift_tz_2023.presentation.HistoryViewModel
import com.example.shift_tz_2023.presentation.ViewModelFactory
import com.example.shift_tz_2023.ui.adapter.CardHistoryAdapter

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: CardHistoryAdapter
    private val viewModel: HistoryViewModel by viewModels{ViewModelFactory(requireContext())}
    var cardInfoData = emptyList<UiCardInfoModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        adapter = CardHistoryAdapter()

        viewModel.dataFromDB.invoke().observe(viewLifecycleOwner, {
            adapter.cardInfoList = it
        })

        adapter.cardInfoList = cardInfoData
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}