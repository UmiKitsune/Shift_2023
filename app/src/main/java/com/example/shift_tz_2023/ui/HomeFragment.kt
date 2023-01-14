package com.example.shift_tz_2023.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shift_tz_2023.R
import com.example.shift_tz_2023.databinding.FragmentHomeBinding
import com.example.shift_tz_2023.presentation.HomeViewModel
import com.example.shift_tz_2023.presentation.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeBtnGetBINData.setOnClickListener {
            val bin = binding.homeBIN.text.trim().toString()
            viewModel.onSearchButtonClick(bin)

            viewModel.emptyField.observe(viewLifecycleOwner, {
                warning(R.color.red, R.string.home_empty_field_warning)
            })

            viewModel.fieldField.observe(viewLifecycleOwner, {
                warning(R.color.gray, R.string.home_under_bin_info)
            })

            viewModel.cardInfo.observe(viewLifecycleOwner, { uiCardInfo ->
                if (uiCardInfo.bin == 0 && uiCardInfo.scheme.isEmpty()) {
                    warning(R.color.red, R.string.home_null_exception)
                } else {
                    viewModel.insertData(uiCardInfo)
                    with(binding) {
                        warning(R.color.gray, R.string.home_under_bin_info)
                        homeScheme.text = uiCardInfo.scheme
                        homeBrand.text = uiCardInfo.brand
                        homeCardNumberLength.text = uiCardInfo.number.length.toString()
                        homeCardNumberLuhn.text = if (uiCardInfo.number.luhn) "Yes" else "No"
                        homeType.text = uiCardInfo.type
                        homePrepaid.text = if (uiCardInfo.prepaid) "Yes" else "No"
                        homeCountry.text = uiCardInfo.country.name
                        homeAlpha2.text = uiCardInfo.country.alpha2
                        homeLatitudeLongitude.text = resources.getString(
                            R.string.home_fragment_latitude_longitude,
                            uiCardInfo.country.latitude.toInt(),
                            uiCardInfo.country.longitude.toInt()
                        )
                        homeBankName.text = uiCardInfo.bank.name
                        homeBankCity.text = uiCardInfo.bank.city
                        homeBankCity.setOnClickListener {
                            dataPasser.mapPass(uiCardInfo.country.latitude, uiCardInfo.country.latitude)
                        }
                        homeBankUrl.text = uiCardInfo.bank.url
                        homeBankUrl.setOnClickListener {
                            dataPasser.urlPass(uiCardInfo.bank.url)
                        }
                        homeBankNumber.text = uiCardInfo.bank.phone
                        homeBankNumber.setOnClickListener {
                            //todo: работает только если 1 номер(пока не успела придумать парсер)
                            dataPasser.phonePass(uiCardInfo.bank.phone)
                        }
                    }
                }
            })
        }
    }

    private fun warning(color: Int, text: Int) {
        binding.homeUnderBINInfo.setTextColor(requireActivity().getColor(color))
        binding.homeUnderBINInfo.text = resources.getString(text)
    }
}

