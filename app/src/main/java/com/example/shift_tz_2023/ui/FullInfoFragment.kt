package com.example.shift_tz_2023.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shift_tz_2023.R
import com.example.shift_tz_2023.databinding.FragmentFullInfoBinding
import com.example.shift_tz_2023.presentation.FullInfoViewModel
import com.example.shift_tz_2023.presentation.ViewModelFactory


class FullInfoFragment : Fragment() {
    lateinit var binding: FragmentFullInfoBinding
    private val viewModel: FullInfoViewModel by viewModels { ViewModelFactory(requireContext()) }
    lateinit var dataPasser: DataFromFrToAct

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as DataFromFrToAct
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullInfoBinding.inflate(inflater, container, false)

        val position = arguments?.getInt("position", 0)!!

        viewModel.dataFromDB.invoke().observe(viewLifecycleOwner, {
            val info = it[position]
            with(binding) {
                fullScheme.text = info.scheme
                fullType.text = info.type
                fullBrand.text = info.brand
                fullPrepaid.text = if (info.prepaid) "Yes" else "No"

                fullCardNumberLength.text = info.number.length.toString()
                fullCardNumberLuhn.text = if (info.number.luhn) "Yes" else "No"

                fullNumeric.text = info.country.numeric
                fullAlpha2.text = info.country.alpha2
                fullCountryName.text = info.country.name
                fullCountryCurrency.text = info.country.currency
                fullLatitudeLongitude.text = resources.getString(
                    R.string.home_fragment_latitude_longitude,
                    info.country.latitude.toInt(),
                    info.country.longitude.toInt()
                )

                fullBankName.text = info.bank.name
                fullBankUrl.text = info.bank.url
                fullBankUrl.setOnClickListener {
                    dataPasser.urlPass(info.bank.url)
                }
                fullBankNumber.text = info.bank.phone
                fullBankNumber.setOnClickListener {
                    dataPasser.phonePass(info.bank.phone)
                }
                fullBankCity.text = info.bank.city
                fullBankCity.setOnClickListener {
                    dataPasser.mapPass(info.country.latitude, info.country.longitude)
                }
            }
        })

        return binding.root
    }
}