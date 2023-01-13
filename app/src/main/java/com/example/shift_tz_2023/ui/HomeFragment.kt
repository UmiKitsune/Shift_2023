package com.example.shift_tz_2023.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.shift_tz_2023.R
import com.example.shift_tz_2023.data.database.CardInfoDatabase
import com.example.shift_tz_2023.data.database.entities.BankEntity
import com.example.shift_tz_2023.data.database.entities.CardInfoEntity
import com.example.shift_tz_2023.data.database.entities.CountryEntity
import com.example.shift_tz_2023.data.database.entities.NumberEntity
import com.example.shift_tz_2023.databinding.FragmentHomeBinding
import com.example.shift_tz_2023.presentation.HomeViewModel
import com.example.shift_tz_2023.presentation.ViewModelFactory
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

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
            viewModel.onSearchButtonClick(bin) //45717360

            viewModel.emptyField.observe(viewLifecycleOwner, {
                binding.homeScheme.text = "error!!!!!"
            })

            //todo: ошибка если пустая строка или меньше 6 текст под полем ввода
            viewModel.cardInfo.observe(viewLifecycleOwner, {
                viewModel.insertData(it)
                if (it.bank.name.isEmpty()) {
                    binding.homeScheme.text = "empty"
                } else {
                    with(binding) {
                        homeScheme.text = it.scheme
                        homeBrand.text = it.brand
                        homeCardNumberLength.text = it.number.length.toString()
                        homeCardNumberLuhn.text = if (it.number.luhn) "Yes" else "No"
                        homeType.text = it.type
                        homePrepaid.text = if (it.prepaid) "Yes" else "No"
                        homeCountry.text = it.country.name
                        homeAlpha2.text = it.country.alpha2
                        homeLatitudeLongitude.text = resources.getString(
                            R.string.home_fragment_latitude_longitude,
                            it.country.latitude,
                            it.country.longitude
                        )
                        homeBankName.text = it.bank.name
                        homeBankCity.text = it.bank.city
                        homeBankUrl.text = it.bank.url
                        homeBankNumber.text = it.bank.phone
                    }

                }

            })

        }

    }
}

