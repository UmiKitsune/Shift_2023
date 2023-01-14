package com.example.shift_tz_2023.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.arraySetOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shift_tz_2023.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), DataFromFrToAct {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            arraySetOf(
                R.id.homeFragment,
                R.id.historyFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun urlPass(text: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://$text")))
    }

    override fun phonePass(number: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("tel:$number")))
    }

    override fun mapPass(lat: Double, long: Double) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=$lat,$long")))
    }
}