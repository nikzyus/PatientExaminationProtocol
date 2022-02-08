package com.example.notes.patientexaminationprotocol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.notes.patientexaminationprotocol.database.FirebaseRepository
import com.example.notes.patientexaminationprotocol.utils.APP_ACTIVITY
import com.example.notes.patientexaminationprotocol.utils.REPOSITORY

class MainActivity : AppCompatActivity() {


    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        REPOSITORY = FirebaseRepository()
    }


}