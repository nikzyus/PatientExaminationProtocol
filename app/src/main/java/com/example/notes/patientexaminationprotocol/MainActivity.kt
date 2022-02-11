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
import com.example.notes.patientexaminationprotocol.utils.REF_DATABASE
import com.example.notes.patientexaminationprotocol.utils.REPOSITORY
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        REPOSITORY = FirebaseRepository()
        REF_DATABASE = FirebaseDatabase.getInstance().reference
    }


}