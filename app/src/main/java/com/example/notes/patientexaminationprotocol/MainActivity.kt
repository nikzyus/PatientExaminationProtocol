package com.example.notes.patientexaminationprotocol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = findViewById(R.id.toolbar)
        navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.authFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)


    }


}