package com.example.shift_tz_2023.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shift_tz_2023.databinding.FragmentFullInfoBinding


class FullInfoFragment : Fragment() {
    lateinit var binding: FragmentFullInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullInfoBinding.inflate(inflater, container, false)

        return binding.root
    }
}