package com.mundroid.apps.shoeapp.ui.activities

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)

        navController = this.findNavController(R.id.navHostFragment)

    }

//    override fun onSupportNavigateUp(): Boolean {
//
//        return NavigationUI.navigateUp(navController, drawerLayout)
//    }

}