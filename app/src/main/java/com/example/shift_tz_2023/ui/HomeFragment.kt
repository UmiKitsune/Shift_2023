package com.example.shift_tz_2023.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shift_tz_2023.R
import com.example.shift_tz_2023.databinding.FragmentHomeBinding
import com.example.shift_tz_2023.presentation.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

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
                binding.homeScheme.text = "error!!!!!"
            })

            //todo: ошибка если пустая строка или меньше 6
            viewModel.cardInfo.observe(viewLifecycleOwner, {
                if (it.bank.name.isEmpty()) {
                    binding.homeScheme.text = "empty"
                } else {
                    binding.homeScheme.text = it.scheme
                    binding.homeBrand.text = it.brand
                    binding.homeCardNumberLength.text = it.number.length.toString()
                    binding.homeCardNumberLuhn.text = if (it.number.luhn) "Yes" else "No"
                    binding.homeType.text = it.type
                    binding.homePrepaid.text = if (it.prepaid) "Yes" else "No"
                    binding.homeCountry.text = it.country.name
                    binding.homeAlpha2.text = it.country.alpha2
                    binding.homeLatitudeLongitude.text = resources.getString(R.string.home_fragment_latitude_longitude, it.country.latitude, it.country.longitude)
                    binding.homeBankName.text = it.bank.name
                    binding.homeBankCity.text = it.bank.city
                    binding.homeBankUrl.text = it.bank.url
                    binding.homeBankNumber.text = it.bank.phone
                }

            })

        }

    }
}

